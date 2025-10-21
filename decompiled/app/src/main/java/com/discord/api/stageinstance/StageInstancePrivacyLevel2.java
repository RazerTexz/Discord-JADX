package com.discord.api.stageinstance;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;

/* compiled from: StageInstancePrivacyLevel.kt */
/* renamed from: com.discord.api.stageinstance.StageInstancePrivacyLevelTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class StageInstancePrivacyLevel2 extends TypeAdapter<StageInstancePrivacyLevel> {
    @Override // com.google.gson.TypeAdapter
    public StageInstancePrivacyLevel read(JsonReader jsonReader) throws IOException {
        StageInstancePrivacyLevel stageInstancePrivacyLevel;
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        int iY = jsonReader.y();
        StageInstancePrivacyLevel[] stageInstancePrivacyLevelArrValues = StageInstancePrivacyLevel.values();
        int i = 0;
        while (true) {
            if (i >= 3) {
                stageInstancePrivacyLevel = null;
                break;
            }
            stageInstancePrivacyLevel = stageInstancePrivacyLevelArrValues[i];
            if (stageInstancePrivacyLevel.getApiValue() == iY) {
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
            jsonWriter.D(Integer.valueOf(stageInstancePrivacyLevel2.getApiValue()));
        } else {
            jsonWriter.s();
        }
    }
}
