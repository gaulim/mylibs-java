
package kr.gaulim.lib.string.regexp;


public class REGEXP
{
    // 색상 코드 - /^(?:#|0x)?([A-Fa-f\d]{8}|[A-Fa-f\d]{6}|[A-Fa-f\d]{3})$/
    public static final String COLOR = "^(?:#|0x)?([A-Fa-f\\d]{8}|[A-Fa-f\\d]{6}|[A-Fa-f\\d]{3})$";

    // 전자우편 - /^(?:mailto[:][/][/])?(?:([.\-\w]+)(?:[:](.+))?@)?(?:((?:(?:(?:25[0-5]|2[0-4]\d|[01]?\d\d?)[.]){3}(?:25[0-5]|2[0-4]\d|[01]?\d\d?))|(?:(?:[A-Za-z가-힣.\-\d]+)[.](?:[A-Za-z가-힣.]{2,6}))))$/
    public static final String EMAIL = "^(?:mailto[:][/][/])?(?:([.\\-\\w]+)(?:[:](.+))?@)?(?:((?:(?:(?:25[0-5]|2[0-4]\\d|[01]?\\d\\d?)[.]){3}(?:25[0-5]|2[0-4]\\d|[01]?\\d\\d?))|(?:(?:[A-Za-z가-힣.\\-\\d]+)[.](?:[A-Za-z가-힣.]{2,6}))))$";

    // 16진수 - /^(?:0x)?([A-Fa-f\d]+)$/
    public static final String HEX = "^(?:0x)?([A-Fa-f\\d]+)$";

    // IPv4 - /^((?:(?:25[0-5]|2[0-4]\d|[01]?\d\d?)[.]){3}(?:25[0-5]|2[0-4]\d|[01]?\d\d?))$/
    public static final String IP4 = "^((?:(?:25[0-5]|2[0-4]\\d|[01]?\\d\\d?)[.]){3}(?:25[0-5]|2[0-4]\\d|[01]?\\d\\d?))$";

    // 포트번호 - /^(6553[0-5]|655[0-2]\d|65[0-4]\d{2}|6[0-4]\d{3}|[1-5]?\d{0,4})$/
    public static final String PORT_NUM = "^(6553[0-5]|655[0-2]\\d|65[0-4]\\d{2}|6[0-4]\\d{3}|[1-5]?\\d{0,4})$";

    // 태그 - /^[<]([A-Za-z]+)(?:\s(\w+=(?:\"[^>]+\"|\'[^>]+\'|[^>]+)))*(?:[>](.*)[<][/]\1)?\s?[/]?[>]$/
    public static final String TAG = "^[<]([A-Za-z]+)(?:\\s(\\w+=(?:\\\"[^>]+\\\"|\\'[^>]+\\'|[^>]+)))*(?:[>](.*)[<][/]\\1)?\\s?[/]?[>]$";

    // 태그 SRC - /src=[\'\"]?([/]?[/]?\b[^\'\"]*)[\'\"]?/
    public static final String TAG_SRC = "src=[\\'\\\"]?([/]?[/]?\\b[^\\'\\\"]*)[\\'\\\"]?";

    // URL - /^(?:(\w+)[:][/][/])?(?:([.\-\w]+)(?:[:](.+))?@)?(?:((?:(?:(?:25[0-5]|2[0-4]\d|[01]?\d\d?)[.]){3}(?:25[0-5]|2[0-4]\d|[01]?\d\d?))|(?:(?:[A-Za-z가-힣.\-\d]+)[.](?:[A-Za-z가-힣.]{2,6})))(?:[:](6553[0-5]|655[0-2]\d|65[0-4]\d{2}|6[0-4]\d{3}|[1-5]?\d{0,4}))?)(?:([/_.\-\w]+)([?]\w+=[%\w]+(?:[&]\w+=[%\w]+)*)?)?$/
    public static final String URL = "^(?:(\\w+)[:][/][/])?(?:([.\\-\\w]+)(?:[:](.+))?@)?(?:((?:(?:(?:25[0-5]|2[0-4]\\d|[01]?\\d\\d?)[.]){3}(?:25[0-5]|2[0-4]\\d|[01]?\\d\\d?))|(?:(?:[A-Za-z가-힣.\\-\\d]+)[.](?:[A-Za-z가-힣.]{2,6})))(?:[:](6553[0-5]|655[0-2]\\d|65[0-4]\\d{2}|6[0-4]\\d{3}|[1-5]?\\d{0,4}))?)(?:([/_.\\-\\w]+)([?]\\w+=[%\\w]+(?:[&]\\w+=[%\\w]+)*)?)?$";

    // UUID - /^([A-Fa-f\d]{8}[\-\s]?[A-Fa-f\d]{4}[\-\s]?[A-Fa-f\d]{4}[\-\s]?[A-Fa-f\d]{4}[\-\s]?[A-Fa-f\d]{12})$/
    public static final String UUID = "^([A-Fa-f\\d]{8}[\\-\\s]?[A-Fa-f\\d]{4}[\\-\\s]?[A-Fa-f\\d]{4}[\\-\\s]?[A-Fa-f\\d]{4}[\\-\\s]?[A-Fa-f\\d]{12})$";


    private REGEXP() { }

    // End of REGEXP.class
}

// End of REGEXP.java

