package id.whoosh;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class WhooshConstant {

    /**
     * param
     */
    public static final String CURRENCY = "IDR";

    /**
     * zoned
     */
    public static final ZoneId ZONE_ID = ZoneId.of("Asia/Jakarta");

    /**
     * DateTime
     */
    public static final String F_0 = "yyyy-MM-dd'T'HH:mm:ssXXX";
    public static final DateTimeFormatter DF_0 = DateTimeFormatter.ofPattern(F_0);

    /**
     * merchantID.
     * From merchant platform
     */
    public static final String MERCHANT_ID = "10001";

    /**
     * MerchantSecret.
     * From merchant platform
     */
    public static final String MERCHANT_SECRET = "a5dca67e25c0f96dda9534f922c0e6ec14a1ea259edb5c55e2fc5538de5f2492";

    /**
     * SANDBOX URL.
     * From docs API
     */
    public static final String BASE_SANDBOX_URL = "https://sandbox-gateway.whooshpay.id";

    /**
     * PRODUCTION URL. From docs API. <br>
     * If you pass the sandbox docking, you can switch the URL to production.
     */
    public static final String BASE_URL = "https://gateway.whooshpay.id";

    /**
     * AccessToken_API.
     * From docs API
     */
    public static final String ACCESS_TOKEN_API = "/v1.0/access-token/b2b";

    /**
     * Payin_API.
     * From docs API
     */
    public static final String PAY_IN_API = "/v1.0/transaction/pay-in";

    /**
     * Payout_API.
     * From docs API
     */
    public static final String PAY_OUT_API = "/v1.0/disbursement/pay-out";

    /**
     * PAY_OUT_INQUIRY_PAYMENT_METHOD_API.
     * From docs API
     */
    public static final String PAY_OUT_INQUIRY_PAYMENT_METHOD_API = "/v1.0/disbursement/inquiry-paymentMethod";

    /**
     * PAY_OUT_INQUIRY_ACCOUNT_API.
     * From docs API
     */
    public static final String PAY_OUT_INQUIRY_ACCOUNT_API = "/v1.0/disbursement/inquiry-account";

    /**
     * INQUIRY_BALANCE_API.
     * From docs API
     * Both are valid
     */
    public static final String INQUIRY_BALANCE_API = "/v1.0/balance-inquiry";
    public static final String INQUIRY_BALANCE_NEW_API = "/v1.0/inquiry-balance";

    /**
     * INQUIRY_STATUS_API
     * INQUIRY_STATUS_NEW_API
     * Both are valid
     */
    public static final String INQUIRY_STATUS_API = "/v1.0/inquiryStatus";
    public static final String INQUIRY_STATUS_NEW_API = "/v1.0/inquiry-status";

    /**
     * QRIS_SC_API
     */
    public static final String QRIS_SC_API = "/v1.0/qris-sc";

}


