package com.discord.api.friendsuggestions;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.api.friendsuggestions.AllowedInSuggestionsTypeAdapter, reason: use source file name */
/* JADX INFO: compiled from: AllowedInSuggestionsType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AllowedInSuggestionsType2 extends TypeAdapter<AllowedInSuggestionsType> {
    @Override // com.google.gson.TypeAdapter
    public AllowedInSuggestionsType read(JsonReader jsonReader) throws IOException {
        AllowedInSuggestionsType allowedInSuggestionsType;
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        int iMo6891y = jsonReader.mo6891y();
        AllowedInSuggestionsType[] allowedInSuggestionsTypeArrValues = AllowedInSuggestionsType.values();
        int i = 0;
        while (true) {
            if (i >= 3) {
                allowedInSuggestionsType = null;
                break;
            }
            allowedInSuggestionsType = allowedInSuggestionsTypeArrValues[i];
            if (allowedInSuggestionsType.getApiValue() == iMo6891y) {
                break;
            }
            i++;
        }
        return allowedInSuggestionsType != null ? allowedInSuggestionsType : AllowedInSuggestionsType.DISABLED;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, AllowedInSuggestionsType allowedInSuggestionsType) throws IOException {
        AllowedInSuggestionsType allowedInSuggestionsType2 = allowedInSuggestionsType;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (allowedInSuggestionsType2 != null) {
            jsonWriter.mo6894D(Integer.valueOf(allowedInSuggestionsType2.getApiValue()));
        } else {
            jsonWriter.mo6905s();
        }
    }
}
