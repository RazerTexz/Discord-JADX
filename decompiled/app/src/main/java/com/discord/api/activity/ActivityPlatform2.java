package com.discord.api.activity;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Locale;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.api.activity.ActivityPlatformTypeAdapter, reason: use source file name */
/* JADX INFO: compiled from: ActivityPlatform.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityPlatform2 extends TypeAdapter<ActivityPlatform> {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.google.gson.TypeAdapter
    public ActivityPlatform read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        String strMo6877J = jsonReader.mo6877J();
        if (strMo6877J != null) {
            switch (strMo6877J.hashCode()) {
                case -1998723398:
                    if (strMo6877J.equals("spotify")) {
                        return ActivityPlatform.SPOTIFY;
                    }
                    break;
                case -861391249:
                    if (strMo6877J.equals("android")) {
                        return ActivityPlatform.ANDROID;
                    }
                    break;
                case 104461:
                    if (strMo6877J.equals("ios")) {
                        return ActivityPlatform.IOS;
                    }
                    break;
                case 111249:
                    if (strMo6877J.equals("ps4")) {
                        return ActivityPlatform.PS4;
                    }
                    break;
                case 111250:
                    if (strMo6877J.equals("ps5")) {
                        return ActivityPlatform.PS5;
                    }
                    break;
                case 3672659:
                    if (strMo6877J.equals("xbox")) {
                        return ActivityPlatform.XBOX;
                    }
                    break;
                case 1557106716:
                    if (strMo6877J.equals("desktop")) {
                        return ActivityPlatform.DESKTOP;
                    }
                    break;
                case 1864941562:
                    if (strMo6877J.equals("samsung")) {
                        return ActivityPlatform.SAMSUNG;
                    }
                    break;
            }
        }
        return ActivityPlatform.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, ActivityPlatform activityPlatform) throws IOException {
        String lowerCase;
        String strName;
        ActivityPlatform activityPlatform2 = activityPlatform;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (activityPlatform2 == null || (strName = activityPlatform2.name()) == null) {
            lowerCase = null;
        } else {
            Locale locale = Locale.ROOT;
            Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ROOT");
            lowerCase = strName.toLowerCase(locale);
            Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        }
        jsonWriter.mo6895H(lowerCase);
    }
}
