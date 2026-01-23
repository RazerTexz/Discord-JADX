package com.discord.api.guildrolesubscription;

import com.discord.api.guildrolesubscription.PayoutGroupStatus;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Objects;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.api.guildrolesubscription.PayoutGroupStatusTypeAdapter, reason: use source file name */
/* JADX INFO: compiled from: PayoutGroupStatus.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PayoutGroupStatus2 extends TypeAdapter<PayoutGroupStatus> {
    @Override // com.google.gson.TypeAdapter
    public PayoutGroupStatus read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        PayoutGroupStatus.Companion companion = PayoutGroupStatus.INSTANCE;
        int iMo6891y = jsonReader.mo6891y();
        Objects.requireNonNull(companion);
        return iMo6891y != 1 ? iMo6891y != 2 ? iMo6891y != 3 ? PayoutGroupStatus.UNKNOWN : PayoutGroupStatus.CANCELED : PayoutGroupStatus.PAYOUT_CREATED : PayoutGroupStatus.OPEN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, PayoutGroupStatus payoutGroupStatus) throws IOException {
        PayoutGroupStatus payoutGroupStatus2 = payoutGroupStatus;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (payoutGroupStatus2 != null) {
            jsonWriter.mo6894D(Integer.valueOf(payoutGroupStatus2.getApiValue()));
        } else {
            jsonWriter.mo6905s();
        }
    }
}
