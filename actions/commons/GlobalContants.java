package commons;

import org.bouncycastle.pqc.crypto.util.PQCOtherInfoGenerator;

public class GlobalContants {
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String JAVA_VERSION = System.getProperty("java.version");
    public static final String SEPARATOR = System.getProperty("file.separator");

    public static final String DEV_USER_URL = "https://demo.nopcommerce.com/";
    public static final String STAGING_USER_URL = "https://staging.nopcommerce.com/";
    public static final String LIVE_USER_URL = "https://live.nopcommerce.com/";

    public static final String DEV_ADMIN_URL = "https://admin-demo.nopcommerce.com";
    public static final String STAGING_ADMIN_URL = "https://admin-staging.nopcommerce.com";
    public static final String LIVE_ADMIN_URL = "https://admin-live.nopcommerce.com";

    public static final String ADMIN_USERNAME = "user01";
    public static final String ADMIN_PASSWORD = "guru99com";

    public static final long SHORT_TIMEOUT = 10;
    public static final long LONG_TIMEOUT = 30;

    public static final String UPLOAD_PATH = PROJECT_PATH + SEPARATOR + "uploadFiles" + SEPARATOR;
    public static final String DOWNLOAD_PATH = PROJECT_PATH + SEPARATOR + "downloadFiles" + SEPARATOR;

    public static final int RETRY_NUMBER = 3;

    public static final String BROWSER_LOG_PATH = PROJECT_PATH + SEPARATOR + "browserLogs" + SEPARATOR;
    public static final String BROWSER_EXTENSION_PATH = PROJECT_PATH + SEPARATOR + "browserExtensions" + SEPARATOR;

    public static final String REPORTNG_PATH = PROJECT_PATH + SEPARATOR + "htmlReportNG" + SEPARATOR;
    public static final String EXTENT_PATH = PROJECT_PATH + SEPARATOR + "htmlExtent" + SEPARATOR;
    public static final String ALLURE_PATH = PROJECT_PATH + SEPARATOR + "htmlAllure" + SEPARATOR;

    public static final String DATA_TEST_PATH = PROJECT_PATH + SEPARATOR + "dataTest"+ SEPARATOR ;
    public static final String ENVIRONMENT_CONFIG_PATH = PROJECT_PATH + SEPARATOR + "environmentConfig" + SEPARATOR;

    public static final String JIRA_SITE_URL = "https://automationfc-vn1.atlassian.net/";
    public static final String JIRA_USER_NAME = "donguyenthanhluan123@gmail.com";
    public static final String JIRA_API_KEY = "ATATT3xFfGF0XgYGiSNqm2_EX32bDfra5qW2m5b9P5fOSNLGoBhuBap3iJHiaGwVUbKxPhjE6d8odny7oqA7MjHboKAKQ_Uuyo88YYWmdHkkVFNIGCK2Lmuph40eN9n7dwq5hff_lwHxneLxziN08C6rrKeCvlyS12wXXihKLWBPtbfSWI16ekA=F1F7B8AB";
    public static final String JIRA_PROJECT_KEY = "SCRUM";

    public static final String BROWSER_USERNAME = "automationfc1";
    public static final String BROWSER_AUTOMATE_KEY = "HzcRC4Q1fzuQhRJYSkhz";
    public static final String BROWSER_STACK_URL = "https://" + BROWSER_USERNAME + ":" + BROWSER_AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static final String SAUCE_USERNAME = "oauth-daominhdam-84f72";
    public static final String SAUCE_AUTOMATE_KEY = "2c7c9f48-ecf6-4e95-a15a-2f8e0d43dc1f";
    public static final String SAUCE_DATA_CENTER_ENDPOINT = "eu-central-1";
    public static final String SAUCE_URL = "https://" + SAUCE_USERNAME + ":" + SAUCE_AUTOMATE_KEY + "@ondemand." +SAUCE_DATA_CENTER_ENDPOINT +  ".saucelabs.com:443/wd/hub";

    public static final String LAMBDA_USERNAME = "daominhdam";
    public static final String LAMBDA_AUTOMATE_KEY = "2c7c9f48-ecf6-4e95-a15a-2f8e0d43dc1f";
    public static final String LAMBDA_URL = "https://hub.lambdatest.com/wd/hub/";

    public static final String BITBAR_AUTOMATE_KEY = "2uj8qEhFy28N2MmNbWVyoMUBT2A2iQe";
    public static final String BITBAR_EU_URL = "https://" + BROWSER_USERNAME + ":" + BROWSER_AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static final String AWS_DEVICE_FARM_ARN = "arn:aws:devicefarm:us-west-2:4884428139224:testgrid-project:306531b0-2d8c-4f6a-933f-2a6adca22c2f";

}
