package com.discord.api.friendsuggestions;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;

/* compiled from: FriendSuggestionReasonType.kt */
/* renamed from: com.discord.api.friendsuggestions.FriendSuggestionReasonTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class FriendSuggestionReasonType2 extends TypeAdapter<FriendSuggestionReasonType> {
    @Override // com.google.gson.TypeAdapter
    public FriendSuggestionReasonType read(JsonReader jsonReader) throws IOException {
        FriendSuggestionReasonType friendSuggestionReasonType;
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        int iY = jsonReader.y();
        FriendSuggestionReasonType[] friendSuggestionReasonTypeArrValues = FriendSuggestionReasonType.values();
        int i = 0;
        while (true) {
            if (i >= 2) {
                friendSuggestionReasonType = null;
                break;
            }
            friendSuggestionReasonType = friendSuggestionReasonTypeArrValues[i];
            if (friendSuggestionReasonType.getApiValue() == iY) {
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
            jsonWriter.D(Integer.valueOf(friendSuggestionReasonType2.getApiValue()));
        } else {
            jsonWriter.s();
        }
    }
}
