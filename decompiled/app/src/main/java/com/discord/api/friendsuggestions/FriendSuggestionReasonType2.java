package com.discord.api.friendsuggestions;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.api.friendsuggestions.FriendSuggestionReasonTypeAdapter, reason: use source file name */
/* JADX INFO: compiled from: FriendSuggestionReasonType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FriendSuggestionReasonType2 extends TypeAdapter<FriendSuggestionReasonType> {
    @Override // com.google.gson.TypeAdapter
    public FriendSuggestionReasonType read(JsonReader jsonReader) throws IOException {
        FriendSuggestionReasonType friendSuggestionReasonType;
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        int iMo6891y = jsonReader.mo6891y();
        FriendSuggestionReasonType[] friendSuggestionReasonTypeArrValues = FriendSuggestionReasonType.values();
        int i = 0;
        while (true) {
            if (i >= 2) {
                friendSuggestionReasonType = null;
                break;
            }
            friendSuggestionReasonType = friendSuggestionReasonTypeArrValues[i];
            if (friendSuggestionReasonType.getApiValue() == iMo6891y) {
                break;
            }
            i++;
        }
        return friendSuggestionReasonType != null ? friendSuggestionReasonType : FriendSuggestionReasonType.NONE;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, FriendSuggestionReasonType friendSuggestionReasonType) throws IOException {
        FriendSuggestionReasonType friendSuggestionReasonType2 = friendSuggestionReasonType;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (friendSuggestionReasonType2 != null) {
            jsonWriter.mo6894D(Integer.valueOf(friendSuggestionReasonType2.getApiValue()));
        } else {
            jsonWriter.mo6905s();
        }
    }
}
