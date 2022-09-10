# web-redirector

Web service that redirects all request to specific URL.

## Environment Variables

`REDIRECT_URL`  
This variable is mandatory and specifies the url to redirect.

`USE_HTTPS`  
This variable is optional. Set to `true`, to enable https.

`CERT_FILE`, `KEY_FILE`  
These variables are mandatory if `USE_HTTPS` is set. Specify SSL cert and key file path.
