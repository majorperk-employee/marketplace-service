package com.majorperk.marketservice.utils;

public class Constants {
    public static final Integer USD_PTS_CONVERSION = 50;


    /* AWS S3 */

    public static final String DEFAULT_FOLDER = "default_data";
    public static final String DEFAULT_CATEGORIES = "/defaultCategories.json";
    public static final String DEFAULT_ACCOUNTS = "/defaultAccounts.json";
    public static final String DEFAULT_BRANDS = "/TangoCardRewards.json";
    public static final String S_AND_P_EMPLOYEES = "/S&P-Sample-Data-employees.csv";
    public static final String DEFAULT_SURVEY = "/Sample-Survey.json";
    
    /* POSTGRES */
    
    //BRAND Table
    public static final String BRAND_TABLE = "brand";
    public static final String BRAND_TABLE_ID_FIELD = "id";
    public static final String BRAND_TABLE_KEY = "brand_key";
    public static final String BRAND_TABLE_NAME = "brand_name";
    public static final String BRAND_TABLE_DESC_LONG = "description";
    public static final String BRAND_TABLE_DESC_SHORT = "short_description";
    public static final String BRAND_TABLE_DISCLAIMER = "disclaimer";
    public static final String BRAND_TABLE_LAST_UPDATE = "last_update_date";
    public static final String BRAND_TABLE_CREATED = "created_date";
    public static final String BRAND_TABLE_STATUS = "status";
    public static final String BRAND_TABLE_TERMS = "terms";
    public static final String BRAND_TABLE_REQ_ID = "brand_requirements_id";
    public static final String BRAND_TABLE_IMG_URLS = "image_urls_id";

    public static final String BRAND_OBJECT = "Brand";
    public static final String BRAND_OBJECT_ID = "id";
    public static final String BRAND_OBJECT_KEY = "brandKey";
    public static final String BRAND_OBJECT_NAME = "brandName";
    public static final String BRAND_OBJECT_DESC_SHORT = "shortDescription";
    public static final String BRAND_OBJECT_STATUS = "status";
    public static final String BRAND_OBJECT_IMG_URLS = "imageUrls";

    //REWARD ITEMS Table
    public static final String REWARDS_TABLE = "reward_item";
    public static final String REWARDS_TABLE_ID_FIELD = "id";
    public static final String REWARDS_TABLE_COUNTRIES = "countries";
    public static final String REWARDS_TABLE_CREATED = "created_date";
    public static final String REWARDS_TABLE_CRED_TYPES = "credential_types";
    public static final String REWARDS_TABLE_CURRENCY = "currency_code";
    public static final String REWARDS_TABLE_FACE_VALUE = "face_value";
    public static final String REWARDS_TABLE_REQ_FULL_AMOUNT = "is_whole_amount_value_required";
    public static final String REWARDS_TABLE_LAST_UPDATE = "last_update_date";
    public static final String REWARDS_TABLE_MAX_VALUE = "max_value";
    public static final String REWARDS_TABLE_MIN_VALUE = "min_value";
    public static final String REWARDS_TABLE_PRICE = "price";
    public static final String REWARDS_TABLE_REDEMPTION_INSTRUCTIONS = "redemption_instructions";
    public static final String REWARDS_TABLE_REWARD_NAME = "reward_name";
    public static final String REWARDS_TABLE_REWARD_TYPE = "reward_type";
    public static final String REWARDS_TABLE_STATUS = "status";
    public static final String REWARDS_TABLE_TAGS = "tags";
    public static final String REWARDS_TABLE_UTID = "utid";
    public static final String REWARDS_TABLE_VALUE_TYPE = "value_type";
    public static final String REWARDS_TABLE_BRAND_ID = "brand_id";
    public static final String REWARDS_TABLE_META_ID = "meta_id";
}