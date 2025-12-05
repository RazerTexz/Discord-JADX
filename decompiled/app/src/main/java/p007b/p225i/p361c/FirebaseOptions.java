package p007b.p225i.p361c;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.C10800R;
import java.util.Arrays;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p288f.p299e.p304k.C3361j;
import p007b.p225i.p226a.p288f.p299e.p308o.C3406h;

/* compiled from: FirebaseOptions.java */
/* renamed from: b.i.c.i, reason: use source file name */
/* loaded from: classes3.dex */
public final class FirebaseOptions {

    /* renamed from: a */
    public final String f12134a;

    /* renamed from: b */
    public final String f12135b;

    /* renamed from: c */
    public final String f12136c;

    /* renamed from: d */
    public final String f12137d;

    /* renamed from: e */
    public final String f12138e;

    /* renamed from: f */
    public final String f12139f;

    /* renamed from: g */
    public final String f12140g;

    public FirebaseOptions(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        AnimatableValueParser.m435G(!C3406h.m4371a(str), "ApplicationId must be set.");
        this.f12135b = str;
        this.f12134a = str2;
        this.f12136c = str3;
        this.f12137d = str4;
        this.f12138e = str5;
        this.f12139f = str6;
        this.f12140g = str7;
    }

    @Nullable
    /* renamed from: a */
    public static FirebaseOptions m6337a(@NonNull Context context) throws Resources.NotFoundException {
        Objects.requireNonNull(context, "null reference");
        Resources resources = context.getResources();
        String resourcePackageName = resources.getResourcePackageName(C10800R.a.common_google_play_services_unknown_issue);
        int identifier = resources.getIdentifier("google_app_id", "string", resourcePackageName);
        String string = identifier == 0 ? null : resources.getString(identifier);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        int identifier2 = resources.getIdentifier("google_api_key", "string", resourcePackageName);
        String string2 = identifier2 == 0 ? null : resources.getString(identifier2);
        int identifier3 = resources.getIdentifier("firebase_database_url", "string", resourcePackageName);
        String string3 = identifier3 == 0 ? null : resources.getString(identifier3);
        int identifier4 = resources.getIdentifier("ga_trackingId", "string", resourcePackageName);
        String string4 = identifier4 == 0 ? null : resources.getString(identifier4);
        int identifier5 = resources.getIdentifier("gcm_defaultSenderId", "string", resourcePackageName);
        String string5 = identifier5 == 0 ? null : resources.getString(identifier5);
        int identifier6 = resources.getIdentifier("google_storage_bucket", "string", resourcePackageName);
        String string6 = identifier6 == 0 ? null : resources.getString(identifier6);
        int identifier7 = resources.getIdentifier("project_id", "string", resourcePackageName);
        return new FirebaseOptions(string, string2, string3, string4, string5, string6, identifier7 != 0 ? resources.getString(identifier7) : null);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FirebaseOptions)) {
            return false;
        }
        FirebaseOptions firebaseOptions = (FirebaseOptions) obj;
        return AnimatableValueParser.m524h0(this.f12135b, firebaseOptions.f12135b) && AnimatableValueParser.m524h0(this.f12134a, firebaseOptions.f12134a) && AnimatableValueParser.m524h0(this.f12136c, firebaseOptions.f12136c) && AnimatableValueParser.m524h0(this.f12137d, firebaseOptions.f12137d) && AnimatableValueParser.m524h0(this.f12138e, firebaseOptions.f12138e) && AnimatableValueParser.m524h0(this.f12139f, firebaseOptions.f12139f) && AnimatableValueParser.m524h0(this.f12140g, firebaseOptions.f12140g);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f12135b, this.f12134a, this.f12136c, this.f12137d, this.f12138e, this.f12139f, this.f12140g});
    }

    public String toString() {
        C3361j c3361j = new C3361j(this);
        c3361j.m4162a("applicationId", this.f12135b);
        c3361j.m4162a("apiKey", this.f12134a);
        c3361j.m4162a("databaseUrl", this.f12136c);
        c3361j.m4162a("gcmSenderId", this.f12138e);
        c3361j.m4162a("storageBucket", this.f12139f);
        c3361j.m4162a("projectId", this.f12140g);
        return c3361j.toString();
    }
}
