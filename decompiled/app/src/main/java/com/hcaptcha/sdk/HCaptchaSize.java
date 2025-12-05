package com.hcaptcha.sdk;

import androidx.annotation.NonNull;
import com.adjust.sdk.Constants;
import java.io.Serializable;
import p007b.p195g.p196a.p197a.JsonValue;

/* loaded from: classes3.dex */
public enum HCaptchaSize implements Serializable {
    INVISIBLE("invisible"),
    NORMAL(Constants.NORMAL),
    COMPACT("compact");

    private final String size;

    HCaptchaSize(String str) {
        this.size = str;
    }

    public String getSize() {
        return this.size;
    }

    @Override // java.lang.Enum
    @NonNull
    @JsonValue
    public String toString() {
        return this.size;
    }
}
