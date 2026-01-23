package com.discord.api.premium;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import kotlin.NoWhenBranchMatchedException;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.api.premium.PriceTierTypeAdapter, reason: use source file name */
/* JADX INFO: compiled from: PriceTierType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PriceTierType2 extends TypeAdapter<PriceTierType> {

    /* JADX INFO: renamed from: com.discord.api.premium.PriceTierTypeAdapter$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            PriceTierType.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[PriceTierType.GUILD_ROLE_SUBSCRIPTIONS.ordinal()] = 1;
            iArr[PriceTierType.UNKNOWN.ordinal()] = 2;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public PriceTierType read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        Integer numM549n1 = AnimatableValueParser.m549n1(jsonReader);
        return (numM549n1 != null && numM549n1.intValue() == 1) ? PriceTierType.GUILD_ROLE_SUBSCRIPTIONS : PriceTierType.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, PriceTierType priceTierType) throws IOException {
        Integer num;
        PriceTierType priceTierType2 = priceTierType;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (priceTierType2 == null) {
            jsonWriter.mo6905s();
            return;
        }
        int iOrdinal = priceTierType2.ordinal();
        if (iOrdinal == 0) {
            num = null;
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            num = 1;
        }
        jsonWriter.mo6894D(num);
    }
}
