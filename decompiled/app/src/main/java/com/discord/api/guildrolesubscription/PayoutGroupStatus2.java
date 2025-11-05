package com.discord.api.guildrolesubscription;

import com.discord.api.guildrolesubscription.PayoutGroupStatus;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.Objects;

/* compiled from: PayoutGroupStatus.kt */
/* renamed from: com.discord.api.guildrolesubscription.PayoutGroupStatusTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class PayoutGroupStatus2 extends TypeAdapter<PayoutGroupStatus> {
    @Override // com.google.gson.TypeAdapter
    public PayoutGroupStatus read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        PayoutGroupStatus.Companion companion = PayoutGroupStatus.INSTANCE;
        int iY = jsonReader.y();
        Objects.requireNonNull(companion);
        return iY != 1 ? iY != 2 ? iY != 3 ? PayoutGroupStatus.UNKNOWN : PayoutGroupStatus.CANCELED : PayoutGroupStatus.PAYOUT_CREATED : PayoutGroupStatus.OPEN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, PayoutGroupStatus payoutGroupStatus) throws IOException {
        PayoutGroupStatus payoutGroupStatus2 = payoutGroupStatus;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (payoutGroupStatus2 != null) {
            jsonWriter.D(Integer.valueOf(payoutGroupStatus2.getApiValue()));
        } else {
            jsonWriter.s();
        }
    }
}
