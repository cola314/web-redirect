# web-redirector

Web service that redirects all request to specific URL.

## Environment Variables

`REDIRECT_URL`  
This variable is mandatory and specifies the url to redirect.

`USE_HTTPS`  
This variable is optional. Set to a non-empty value, like `true`, to enable https.

`CERT_FILE`, `KEY_FILE`  
These variables are mandatory if `USE_HTTPS` is set. Specify SSL cert and key file path.

`USE_ELASTIC_SEARCH_EXPORT`  
This variable is optional. Set to a non-empty value, like `true`, to enable exporting information to elasticsearch.

`ELASTIC_SEARCH_URL`  
These variables are mandatory if `USE_ELASTIC_SEARCH_EXPORT` is set. Specify url of elasticsearch.
