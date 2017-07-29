package com.ifiok.cardentry.library;

import android.support.annotation.DrawableRes;

import com.ifiok.cardentry.R;

import java.io.Serializable;

class CardRegex {
    // See: http://www.regular-expressions.info/creditcard.html
    static final String REGX_VISA = "^4[0-9]{15}?"; // VISA 16
    static final String REGX_MC = "^5[1-5][0-9]{14}$"; // MC 16
    static final String REGX_AMEX = "^3[47][0-9]{13}$"; // AMEX 15
    static final String REGX_DISCOVER = "^6(?:011|5[0-9]{2})[0-9]{12}$"; // Discover 16
    static final String REGX_DINERS_CLUB = "^3(?:0[0-5]|[68][0-9])[0-9]{11}$"; // DinersClub 14
    static final String REGX_JCB = "^35[0-9]{14}$"; // JCB 16
    static final String REGX_VERVE = "^(506099|5061[0-8][0-9]|50619[0-8])[0-9]{13}$"; // Interswitch Verve [Nigeria]
    static final String REGX_PAYSTACK_PIN_OTP = "^5060666666666666666$"; // Paystack PIN+OTP validation
    static final String REGX_PAYSTACK_PIN_ONLY = "^507850785078507812$"; // Paystack PIN Only
    static final String REGX_PAYSTACK_PIN_PHONE_OTP_ONLY = "^50785078507850780$"; // Paystack PIN Only



    static final String REGX_VISA_TYPE = "^4[0-9]{3}?"; // VISA 16
    static final String REGX_MC_TYPE = "^5[1-5][0-9]{2}$"; // MC 16
    static final String REGX_AMEX_TYPE = "^3[47][0-9]{2}$"; // AMEX 15
    static final String REGX_DISCOVER_TYPE = "^6(?:011|5[0-9]{2})$"; // Discover 16
    static final String REGX_DINERS_CLUB_TYPE = "^3(?:0[0-5]|[68][0-9])[0-9]$"; // DinersClub 14
    static final String REGX_JCB_TYPE = "^35[0-9]{2}$"; // JCB 15
    static final String REGX_VERVE_TYPE = "^506[0,1]$"; // Interswitch Verve [Nigeria]
    static final String REGX_PAYSTACK_PIN_OTP_TYPE = "^5060$";
    static final String REGX_PAYSTACK_PIN_ONLY_TYPE = "^5078$";
    static final String REGX_PAYSTACK_PIN_PHONE_OTP_TYPE = "^5078$";

}

/**
 * represents the type of card the user used
 */
public enum CardType implements Serializable {
    PAYSTACK_PIN_OTP("Paystack PIN and OTP", R.drawable.unknown_cc, CardRegex.REGX_PAYSTACK_PIN_OTP, CardRegex.REGX_PAYSTACK_PIN_OTP_TYPE),
    PAYSTACK_PIN_ONLY("Paystack PIN Only", R.drawable.unknown_cc, CardRegex.REGX_PAYSTACK_PIN_ONLY, CardRegex.REGX_PAYSTACK_PIN_ONLY_TYPE),
    PAYSTACK_PIN_PHONE_OTP("Paystack PIN Phone OTP", R.drawable.unknown_cc, CardRegex.REGX_PAYSTACK_PIN_PHONE_OTP_ONLY, CardRegex.REGX_PAYSTACK_PIN_PHONE_OTP_TYPE),
    VISA("VISA", R.drawable.visa, CardRegex.REGX_VISA, CardRegex.REGX_VISA_TYPE),
    MASTERCARD("MasterCard", R.drawable.master_card, CardRegex.REGX_MC, CardRegex.REGX_MC_TYPE),
    AMEX("American Express", R.drawable.amex, CardRegex.REGX_AMEX, CardRegex.REGX_AMEX_TYPE),
    DISCOVER("Discover", R.drawable.discover, CardRegex.REGX_DISCOVER, CardRegex.REGX_DISCOVER_TYPE),
    DINERS("DinersClub",R.drawable.diners_club,CardRegex.REGX_DINERS_CLUB,CardRegex.REGX_DINERS_CLUB_TYPE),
    JCB("JCB",R.drawable.jcb_payment_ico,CardRegex.REGX_JCB,CardRegex.REGX_JCB_TYPE),
    VERVE("Verve", R.drawable.payment_ic_verve, CardRegex.REGX_VERVE, CardRegex.REGX_VERVE_TYPE),
    INVALID("Unknown", R.drawable.unknown_cc, null, null);

  /** name for humans */
    public final String name;

  /** regex that matches the entire card number */
    public final String fullRegex;

  /** regex that will match when there is enough of the card to determine type */
    public final String typeRegex;

  /** drawable for the front of the card */
    public final int frontResource;

  /** drawable for the back of the card */
    public final int backResource = R.drawable.cc_back;

    CardType(String name, @DrawableRes int imageResource, String fullRegex, String typeRegex) {
        this.name = name;
        this.frontResource = imageResource;
        this.fullRegex = fullRegex;
        this.typeRegex = typeRegex;
    }

    @Override
    public String toString() {
        return name;
    }
}
