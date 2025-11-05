package com.discord.api.premium;

import b.c.a.a0.d;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.m;
import java.io.IOException;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: PremiumTier.kt */
/* loaded from: classes.dex */
public final class PremiumTierTypeAdapter extends TypeAdapter<PremiumTier> {

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            PremiumTier.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[PremiumTier.PREMIUM_GUILD_SUBSCRIPTION_ONLY.ordinal()] = 1;
            iArr[PremiumTier.TIER_1.ordinal()] = 2;
            iArr[PremiumTier.TIER_2.ordinal()] = 3;
            iArr[PremiumTier.TIER_0.ordinal()] = 4;
            iArr[PremiumTier.NONE.ordinal()] = 5;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public PremiumTier read(JsonReader jsonReader) throws IOException {
        m.checkNotNullParameter(jsonReader, "in");
        Integer numN1 = d.n1(jsonReader);
        return (numN1 != null && numN1.intValue() == 0) ? PremiumTier.PREMIUM_GUILD_SUBSCRIPTION_ONLY : (numN1 != null && numN1.intValue() == 1) ? PremiumTier.TIER_1 : (numN1 != null && numN1.intValue() == 2) ? PremiumTier.TIER_2 : (numN1 != null && numN1.intValue() == 3) ? PremiumTier.TIER_0 : PremiumTier.NONE;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, PremiumTier premiumTier) throws IOException {
        Integer num;
        PremiumTier premiumTier2 = premiumTier;
        m.checkNotNullParameter(jsonWriter, "out");
        if (premiumTier2 == null) {
            jsonWriter.s();
            return;
        }
        int iOrdinal = premiumTier2.ordinal();
        if (iOrdinal == 0) {
            num = null;
        } else if (iOrdinal == 1) {
            num = 0;
        } else if (iOrdinal == 2) {
            num = 3;
        } else if (iOrdinal == 3) {
            num = 1;
        } else {
            if (iOrdinal != 4) {
                throw new NoWhenBranchMatchedException();
            }
            num = 2;
        }
        jsonWriter.D(num);
    }
}
