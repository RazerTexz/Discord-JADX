package com.discord.utilities.billing;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import com.discord.C5419R;
import com.discord.api.premium.SubscriptionInterval;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p512d0._Ranges;
import p507d0.p580t.MapsJVM;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'PREMIUM_TIER_2_YEARLY' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: GooglePlaySku.kt */
/* loaded from: classes2.dex */
public final class GooglePlaySku {
    private static final /* synthetic */ GooglePlaySku[] $VALUES;
    private static final List<String> ALL_SKU_NAMES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final GooglePlaySku PREMIUM_GUILD_1_MONTHLY;
    public static final GooglePlaySku PREMIUM_GUILD_2_MONTHLY;
    public static final GooglePlaySku PREMIUM_TIER_1_MONTHLY;
    public static final GooglePlaySku PREMIUM_TIER_1_PREMIUM_GUILD_1_MONTHLY;
    public static final GooglePlaySku PREMIUM_TIER_1_PREMIUM_GUILD_1_YEARLY;
    public static final GooglePlaySku PREMIUM_TIER_1_YEARLY;
    public static final GooglePlaySku PREMIUM_TIER_2_MONTHLY;
    public static final GooglePlaySku PREMIUM_TIER_2_PREMIUM_GUILD_10_MONTHLY;
    public static final GooglePlaySku PREMIUM_TIER_2_PREMIUM_GUILD_13_MONTHLY;
    public static final GooglePlaySku PREMIUM_TIER_2_PREMIUM_GUILD_1_MONTHLY;
    public static final GooglePlaySku PREMIUM_TIER_2_PREMIUM_GUILD_1_YEARLY;
    public static final GooglePlaySku PREMIUM_TIER_2_PREMIUM_GUILD_28_MONTHLY;
    public static final GooglePlaySku PREMIUM_TIER_2_PREMIUM_GUILD_2_MONTHLY;
    public static final GooglePlaySku PREMIUM_TIER_2_PREMIUM_GUILD_2_YEARLY;
    public static final GooglePlaySku PREMIUM_TIER_2_PREMIUM_GUILD_3_MONTHLY;
    public static final GooglePlaySku PREMIUM_TIER_2_PREMIUM_GUILD_3_YEARLY;
    public static final GooglePlaySku PREMIUM_TIER_2_PREMIUM_GUILD_5_MONTHLY;
    public static final GooglePlaySku PREMIUM_TIER_2_PREMIUM_GUILD_5_YEARLY;
    public static final GooglePlaySku PREMIUM_TIER_2_YEARLY;
    private static final Map<String, GooglePlaySku> skusBySkuName;
    private final int iconDrawableResId;
    private final SubscriptionInterval interval;
    private final int premiumSubscriptionCount;
    private final String skuName;
    private final Type type;
    private final GooglePlaySku upgrade;

    /* compiled from: GooglePlaySku.kt */
    public static final class Companion {

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                Type.values();
                int[] iArr = new int[5];
                $EnumSwitchMapping$0 = iArr;
                iArr[Type.PREMIUM_TIER_2.ordinal()] = 1;
                iArr[Type.PREMIUM_TIER_1.ordinal()] = 2;
                iArr[Type.PREMIUM_GUILD.ordinal()] = 3;
                iArr[Type.PREMIUM_TIER_2_AND_PREMIUM_GUILD.ordinal()] = 4;
                iArr[Type.PREMIUM_TIER_1_AND_PREMIUM_GUILD.ordinal()] = 5;
            }
        }

        private Companion() {
        }

        public final GooglePlaySku fromSkuName(String skuName) {
            Intrinsics3.checkNotNullParameter(skuName, "skuName");
            return (GooglePlaySku) GooglePlaySku.access$getSkusBySkuName$cp().get(skuName);
        }

        public final List<String> getALL_SKU_NAMES() {
            return GooglePlaySku.access$getALL_SKU_NAMES$cp();
        }

        @DrawableRes
        public final int getBorderResource(Type skuType) {
            Intrinsics3.checkNotNullParameter(skuType, "skuType");
            int iOrdinal = skuType.ordinal();
            if (iOrdinal == 0) {
                return C5419R.drawable.drawable_bg_nitro_gradient_diagonal;
            }
            if (iOrdinal == 1) {
                return C5419R.drawable.drawable_bg_nitro_classic_gradient_diagonal;
            }
            if (iOrdinal == 2) {
                return C5419R.drawable.drawable_bg_premium_tier_2_and_premium_guild_gradient;
            }
            if (iOrdinal == 3) {
                return C5419R.drawable.drawable_bg_premium_tier_1_and_premium_guild_gradient;
            }
            if (iOrdinal == 4) {
                return C5419R.drawable.drawable_bg_premium_guild_gradient;
            }
            throw new NoWhenBranchMatchedException();
        }

        public final GooglePlaySku getDowngrade(String skuName) {
            Intrinsics3.checkNotNullParameter(skuName, "skuName");
            GooglePlaySku[] googlePlaySkuArrValues = GooglePlaySku.values();
            int i = 0;
            while (true) {
                if (i >= 19) {
                    return null;
                }
                GooglePlaySku googlePlaySku = googlePlaySkuArrValues[i];
                GooglePlaySku upgrade = googlePlaySku.getUpgrade();
                if (Intrinsics3.areEqual(upgrade != null ? upgrade.getSkuName() : null, skuName)) {
                    return googlePlaySku;
                }
                i++;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GooglePlaySku.kt */
    public enum Section {
        PREMIUM,
        PREMIUM_AND_PREMIUM_GUILD,
        PREMIUM_GUILD;


        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* compiled from: GooglePlaySku.kt */
        public static final class Companion {

            public final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    Section.values();
                    int[] iArr = new int[3];
                    $EnumSwitchMapping$0 = iArr;
                    iArr[Section.PREMIUM.ordinal()] = 1;
                    iArr[Section.PREMIUM_AND_PREMIUM_GUILD.ordinal()] = 2;
                    iArr[Section.PREMIUM_GUILD.ordinal()] = 3;
                }
            }

            private Companion() {
            }

            @StringRes
            public final int getHeaderResource(Section section) {
                Intrinsics3.checkNotNullParameter(section, "section");
                int iOrdinal = section.ordinal();
                if (iOrdinal == 0) {
                    return C5419R.string.billing_premium_plans;
                }
                if (iOrdinal == 1) {
                    return C5419R.string.billing_premium_and_premium_guild_plans;
                }
                if (iOrdinal == 2) {
                    return C5419R.string.billing_premium_guild_plans;
                }
                throw new NoWhenBranchMatchedException();
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    /* compiled from: GooglePlaySku.kt */
    public enum Type {
        PREMIUM_TIER_2,
        PREMIUM_TIER_1,
        PREMIUM_TIER_2_AND_PREMIUM_GUILD,
        PREMIUM_TIER_1_AND_PREMIUM_GUILD,
        PREMIUM_GUILD
    }

    static {
        Type type = Type.PREMIUM_TIER_2;
        SubscriptionInterval subscriptionInterval = SubscriptionInterval.YEARLY;
        GooglePlaySku googlePlaySku = new GooglePlaySku("PREMIUM_TIER_2_YEARLY", 0, "premium_tier_2_yearly", C5419R.drawable.ic_plan_premium_tier_2, type, null, 2, subscriptionInterval, 8, null);
        PREMIUM_TIER_2_YEARLY = googlePlaySku;
        SubscriptionInterval subscriptionInterval2 = SubscriptionInterval.MONTHLY;
        GooglePlaySku googlePlaySku2 = new GooglePlaySku("PREMIUM_TIER_2_MONTHLY", 1, "premium_tier_2_monthly", C5419R.drawable.ic_plan_premium_tier_2, type, googlePlaySku, 2, subscriptionInterval2);
        PREMIUM_TIER_2_MONTHLY = googlePlaySku2;
        Type type2 = Type.PREMIUM_TIER_1;
        GooglePlaySku googlePlaySku3 = new GooglePlaySku("PREMIUM_TIER_1_YEARLY", 2, "premium_tier_1_yearly", C5419R.drawable.ic_plan_premium_tier_1, type2, null, 0, subscriptionInterval, 8, null);
        PREMIUM_TIER_1_YEARLY = googlePlaySku3;
        GooglePlaySku googlePlaySku4 = new GooglePlaySku("PREMIUM_TIER_1_MONTHLY", 3, "premium_tier_1_monthly", C5419R.drawable.ic_plan_premium_tier_1, type2, googlePlaySku3, 0, subscriptionInterval2);
        PREMIUM_TIER_1_MONTHLY = googlePlaySku4;
        Type type3 = Type.PREMIUM_TIER_2_AND_PREMIUM_GUILD;
        GooglePlaySku googlePlaySku5 = new GooglePlaySku("PREMIUM_TIER_2_PREMIUM_GUILD_1_YEARLY", 4, "premium_tier_2_premium_guild_1_yearly", C5419R.drawable.ic_plan_premium_and_premium_guild_1, type3, null, 3, subscriptionInterval, 8, null);
        PREMIUM_TIER_2_PREMIUM_GUILD_1_YEARLY = googlePlaySku5;
        GooglePlaySku googlePlaySku6 = new GooglePlaySku("PREMIUM_TIER_2_PREMIUM_GUILD_1_MONTHLY", 5, "premium_tier_2_premium_guild_1_monthly", C5419R.drawable.ic_plan_premium_and_premium_guild_1, type3, googlePlaySku5, 3, subscriptionInterval2);
        PREMIUM_TIER_2_PREMIUM_GUILD_1_MONTHLY = googlePlaySku6;
        GooglePlaySku googlePlaySku7 = new GooglePlaySku("PREMIUM_TIER_2_PREMIUM_GUILD_2_YEARLY", 6, "premium_tier_2_premium_guild_2_yearly", C5419R.drawable.ic_plan_premium_and_premium_guild_2, type3, null, 4, subscriptionInterval, 8, null);
        PREMIUM_TIER_2_PREMIUM_GUILD_2_YEARLY = googlePlaySku7;
        GooglePlaySku googlePlaySku8 = new GooglePlaySku("PREMIUM_TIER_2_PREMIUM_GUILD_2_MONTHLY", 7, "premium_tier_2_premium_guild_2_monthly", C5419R.drawable.ic_plan_premium_and_premium_guild_2, type3, googlePlaySku7, 4, subscriptionInterval2);
        PREMIUM_TIER_2_PREMIUM_GUILD_2_MONTHLY = googlePlaySku8;
        GooglePlaySku googlePlaySku9 = new GooglePlaySku("PREMIUM_TIER_2_PREMIUM_GUILD_3_YEARLY", 8, "premium_tier_2_premium_guild_3_yearly", C5419R.drawable.ic_plan_premium_and_premium_guild_3, type3, null, 5, subscriptionInterval, 8, null);
        PREMIUM_TIER_2_PREMIUM_GUILD_3_YEARLY = googlePlaySku9;
        GooglePlaySku googlePlaySku10 = new GooglePlaySku("PREMIUM_TIER_2_PREMIUM_GUILD_3_MONTHLY", 9, "premium_tier_2_premium_guild_3_monthly", C5419R.drawable.ic_plan_premium_and_premium_guild_3, type3, googlePlaySku9, 5, subscriptionInterval2);
        PREMIUM_TIER_2_PREMIUM_GUILD_3_MONTHLY = googlePlaySku10;
        GooglePlaySku googlePlaySku11 = new GooglePlaySku("PREMIUM_TIER_2_PREMIUM_GUILD_5_YEARLY", 10, "premium_tier_2_premium_guild_5_yearly", C5419R.drawable.ic_plan_premium_and_premium_guild_5, type3, null, 7, subscriptionInterval, 8, null);
        PREMIUM_TIER_2_PREMIUM_GUILD_5_YEARLY = googlePlaySku11;
        GooglePlaySku googlePlaySku12 = new GooglePlaySku("PREMIUM_TIER_2_PREMIUM_GUILD_5_MONTHLY", 11, "premium_tier_2_premium_guild_5_monthly", C5419R.drawable.ic_plan_premium_and_premium_guild_5, type3, googlePlaySku11, 7, subscriptionInterval2);
        PREMIUM_TIER_2_PREMIUM_GUILD_5_MONTHLY = googlePlaySku12;
        GooglePlaySku googlePlaySku13 = new GooglePlaySku("PREMIUM_TIER_2_PREMIUM_GUILD_10_MONTHLY", 12, "premium_tier_2_premium_guild_10_monthly", C5419R.drawable.ic_plan_premium_and_premium_guild_10, type3, null, 12, subscriptionInterval2, 8, null);
        PREMIUM_TIER_2_PREMIUM_GUILD_10_MONTHLY = googlePlaySku13;
        GooglePlaySku googlePlaySku14 = new GooglePlaySku("PREMIUM_TIER_2_PREMIUM_GUILD_13_MONTHLY", 13, "premium_tier_2_premium_guild_13_monthly", C5419R.drawable.ic_plan_premium_and_premium_guild_13, type3, null, 15, subscriptionInterval2, 8, null);
        PREMIUM_TIER_2_PREMIUM_GUILD_13_MONTHLY = googlePlaySku14;
        GooglePlaySku googlePlaySku15 = new GooglePlaySku("PREMIUM_TIER_2_PREMIUM_GUILD_28_MONTHLY", 14, "premium_tier_2_premium_guild_28_monthly", C5419R.drawable.ic_plan_premium_and_premium_guild_28, type3, null, 30, subscriptionInterval2, 8, null);
        PREMIUM_TIER_2_PREMIUM_GUILD_28_MONTHLY = googlePlaySku15;
        Type type4 = Type.PREMIUM_TIER_1_AND_PREMIUM_GUILD;
        GooglePlaySku googlePlaySku16 = new GooglePlaySku("PREMIUM_TIER_1_PREMIUM_GUILD_1_YEARLY", 15, "premium_tier_1_premium_guild_1_yearly", C5419R.drawable.ic_plan_premium_tier_1_and_premium_guild_1, type4, null, 1, subscriptionInterval, 8, null);
        PREMIUM_TIER_1_PREMIUM_GUILD_1_YEARLY = googlePlaySku16;
        GooglePlaySku googlePlaySku17 = new GooglePlaySku("PREMIUM_TIER_1_PREMIUM_GUILD_1_MONTHLY", 16, "premium_tier_1_premium_guild_1_monthly", C5419R.drawable.ic_plan_premium_tier_1_and_premium_guild_1, type4, googlePlaySku16, 1, subscriptionInterval2);
        PREMIUM_TIER_1_PREMIUM_GUILD_1_MONTHLY = googlePlaySku17;
        Type type5 = Type.PREMIUM_GUILD;
        GooglePlaySku googlePlaySku18 = new GooglePlaySku("PREMIUM_GUILD_1_MONTHLY", 17, "premium_guild_1_monthly", C5419R.drawable.ic_plan_premium_guild_1, type5, googlePlaySku2, 1, subscriptionInterval2);
        PREMIUM_GUILD_1_MONTHLY = googlePlaySku18;
        GooglePlaySku googlePlaySku19 = new GooglePlaySku("PREMIUM_GUILD_2_MONTHLY", 18, "premium_guild_2_monthly", C5419R.drawable.ic_plan_premium_guild_2, type5, googlePlaySku2, 2, subscriptionInterval2);
        PREMIUM_GUILD_2_MONTHLY = googlePlaySku19;
        $VALUES = new GooglePlaySku[]{googlePlaySku, googlePlaySku2, googlePlaySku3, googlePlaySku4, googlePlaySku5, googlePlaySku6, googlePlaySku7, googlePlaySku8, googlePlaySku9, googlePlaySku10, googlePlaySku11, googlePlaySku12, googlePlaySku13, googlePlaySku14, googlePlaySku15, googlePlaySku16, googlePlaySku17, googlePlaySku18, googlePlaySku19};
        INSTANCE = new Companion(null);
        GooglePlaySku[] googlePlaySkuArrValues = values();
        ArrayList arrayList = new ArrayList(19);
        for (int i = 0; i < 19; i++) {
            arrayList.add(googlePlaySkuArrValues[i].skuName);
        }
        ALL_SKU_NAMES = arrayList;
        GooglePlaySku[] googlePlaySkuArrValues2 = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(19), 16));
        for (int i2 = 0; i2 < 19; i2++) {
            GooglePlaySku googlePlaySku20 = googlePlaySkuArrValues2[i2];
            linkedHashMap.put(googlePlaySku20.skuName, googlePlaySku20);
        }
        skusBySkuName = linkedHashMap;
    }

    private GooglePlaySku(String str, @DrawableRes int i, String str2, int i2, Type type, GooglePlaySku googlePlaySku, int i3, SubscriptionInterval subscriptionInterval) {
        this.skuName = str2;
        this.iconDrawableResId = i2;
        this.type = type;
        this.upgrade = googlePlaySku;
        this.premiumSubscriptionCount = i3;
        this.interval = subscriptionInterval;
    }

    public static final /* synthetic */ List access$getALL_SKU_NAMES$cp() {
        return ALL_SKU_NAMES;
    }

    public static final /* synthetic */ Map access$getSkusBySkuName$cp() {
        return skusBySkuName;
    }

    public static GooglePlaySku valueOf(String str) {
        return (GooglePlaySku) Enum.valueOf(GooglePlaySku.class, str);
    }

    public static GooglePlaySku[] values() {
        return (GooglePlaySku[]) $VALUES.clone();
    }

    public final int getIconDrawableResId() {
        return this.iconDrawableResId;
    }

    public final SubscriptionInterval getInterval() {
        return this.interval;
    }

    public final int getPremiumSubscriptionCount() {
        return this.premiumSubscriptionCount;
    }

    public final String getSkuName() {
        return this.skuName;
    }

    public final Type getType() {
        return this.type;
    }

    public final GooglePlaySku getUpgrade() {
        return this.upgrade;
    }

    public /* synthetic */ GooglePlaySku(String str, int i, String str2, int i2, Type type, GooglePlaySku googlePlaySku, int i3, SubscriptionInterval subscriptionInterval, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, str2, i2, type, (i4 & 8) != 0 ? null : googlePlaySku, i3, subscriptionInterval);
    }
}
