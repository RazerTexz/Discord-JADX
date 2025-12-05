package com.discord.api.stageinstance;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: StageInstancePrivacyLevel.kt */
/* renamed from: com.discord.api.stageinstance.StageInstancePrivacyLevelTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class StageInstancePrivacyLevel2 extends TypeAdapter<StageInstancePrivacyLevel> {
    @Override // com.google.gson.TypeAdapter
    public StageInstancePrivacyLevel read(JsonReader jsonReader) throws IOException {
        StageInstancePrivacyLevel stageInstancePrivacyLevel;
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        int iMo6891y = jsonReader.mo6891y();
        StageInstancePrivacyLevel[] stageInstancePrivacyLevelArrValues = StageInstancePrivacyLevel.values();
        int i = 0;
        while (true) {
            if (i >= 3) {
                stageInstancePrivacyLevel = null;
                break;
            }
            stageInstancePrivacyLevel = stageInstancePrivacyLevelArrValues[i];
            if (stageInstancePrivacyLevel.getApiValue() == iMo6891y) {
                break;
            }
            i++;
        }
        return stageInstancePrivacyLevel != null ? stageInstancePrivacyLevel : StageInstancePrivacyLevel.INVALID;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, StageInstancePrivacyLevel stageInstancePrivacyLevel) throws IOException {
        StageInstancePrivacyLevel stageInstancePrivacyLevel2 = stageInstancePrivacyLevel;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (stageInstancePrivacyLevel2 != null) {
            jsonWriter.mo6894D(Integer.valueOf(stageInstancePrivacyLevel2.getApiValue()));
        } else {
            jsonWriter.mo6905s();
        }
    }
}
