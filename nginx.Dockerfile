server {
    listen 80;
    listen [::]:80;
    server_name x.com;

    location / {
        return 301 https://$host$request_uri;
    }

    location ~ /.well-known/acme-challenge {
        allow all;
        root /tmp/acme_challenge;
    }
}

server {
    listen 443 ssl;
    listen [::]:443 ssl http2;

    ssl_certificate /etc/letsencrypt/live/x.com/fullchain.pem;
    ssl_certificate_key /etc/letsencrypt/live/x.com/privkey.pem;

    location / {
        proxy_pass http://172.18.0.4:8080;
    }
}