package p007b.p225i.p226a.p242c.p257e3;

import android.content.Context;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.discord.api.permission.Permission;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.widgets.chat.input.MentionUtils;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import org.objectweb.asm.Opcodes;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p257e3.BandwidthMeter;
import p007b.p225i.p226a.p242c.p259f3.Clock4;
import p007b.p225i.p226a.p242c.p259f3.NetworkTypeObserver;
import p007b.p225i.p226a.p242c.p259f3.RunnableC2733c;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p357b.ImmutableList2;
import p007b.p225i.p355b.p357b.ImmutableMap2;

/* compiled from: DefaultBandwidthMeter.java */
/* renamed from: b.i.a.c.e3.p, reason: use source file name */
/* loaded from: classes3.dex */
public final class DefaultBandwidthMeter implements BandwidthMeter, TransferListener {

    /* renamed from: a */
    public static final ImmutableList2<Long> f6569a = ImmutableList2.m6267v(5400000L, 3300000L, 2000000L, 1300000L, 760000L);

    /* renamed from: b */
    public static final ImmutableList2<Long> f6570b = ImmutableList2.m6267v(1700000L, 820000L, 450000L, 180000L, 130000L);

    /* renamed from: c */
    public static final ImmutableList2<Long> f6571c = ImmutableList2.m6267v(2300000L, 1300000L, 1000000L, 820000L, 570000L);

    /* renamed from: d */
    public static final ImmutableList2<Long> f6572d = ImmutableList2.m6267v(3400000L, 2000000L, 1400000L, 1000000L, 620000L);

    /* renamed from: e */
    public static final ImmutableList2<Long> f6573e = ImmutableList2.m6267v(7500000L, 5200000L, 3700000L, Long.valueOf(StoreGuildScheduledEvents.FETCH_GUILD_EVENTS_THRESHOLD), 1100000L);

    /* renamed from: f */
    public static final ImmutableList2<Long> f6574f = ImmutableList2.m6267v(3300000L, 1900000L, 1700000L, 1500000L, 1200000L);

    /* renamed from: g */
    @Nullable
    public static DefaultBandwidthMeter f6575g;

    /* renamed from: h */
    public final ImmutableMap2<Integer, Long> f6576h;

    /* renamed from: i */
    public final BandwidthMeter.a.C13224a f6577i = new BandwidthMeter.a.C13224a();

    /* renamed from: j */
    public final SlidingPercentile f6578j;

    /* renamed from: k */
    public final Clock4 f6579k;

    /* renamed from: l */
    public final boolean f6580l;

    /* renamed from: m */
    public int f6581m;

    /* renamed from: n */
    public long f6582n;

    /* renamed from: o */
    public long f6583o;

    /* renamed from: p */
    public int f6584p;

    /* renamed from: q */
    public long f6585q;

    /* renamed from: r */
    public long f6586r;

    /* renamed from: s */
    public long f6587s;

    /* renamed from: t */
    public long f6588t;

    /* compiled from: DefaultBandwidthMeter.java */
    /* renamed from: b.i.a.c.e3.p$b */
    public static final class b {

        /* renamed from: a */
        @Nullable
        public final Context f6589a;

        /* renamed from: b */
        public Map<Integer, Long> f6590b;

        /* renamed from: c */
        public int f6591c;

        /* renamed from: d */
        public Clock4 f6592d;

        /* renamed from: e */
        public boolean f6593e;

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:13:0x002e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b(Context context) {
            String strM4357w1;
            int[] iArr;
            TelephonyManager telephonyManager;
            this.f6589a = context == null ? null : context.getApplicationContext();
            int i = Util2.f6708a;
            if (context == null || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
                strM4357w1 = C3404f.m4357w1(Locale.getDefault().getCountry());
            } else {
                String networkCountryIso = telephonyManager.getNetworkCountryIso();
                if (!TextUtils.isEmpty(networkCountryIso)) {
                    strM4357w1 = C3404f.m4357w1(networkCountryIso);
                }
            }
            ImmutableList2<Long> immutableList2 = DefaultBandwidthMeter.f6569a;
            strM4357w1.hashCode();
            char c = 65535;
            switch (strM4357w1.hashCode()) {
                case 2083:
                    if (strM4357w1.equals("AD")) {
                        c = 0;
                    }
                    break;
                case 2084:
                    if (strM4357w1.equals("AE")) {
                        c = 1;
                    }
                    break;
                case 2085:
                    if (strM4357w1.equals("AF")) {
                        c = 2;
                    }
                    break;
                case 2086:
                    if (strM4357w1.equals("AG")) {
                        c = 3;
                    }
                    break;
                case 2088:
                    if (strM4357w1.equals("AI")) {
                        c = 4;
                    }
                    break;
                case 2091:
                    if (strM4357w1.equals("AL")) {
                        c = 5;
                    }
                    break;
                case 2092:
                    if (strM4357w1.equals("AM")) {
                        c = 6;
                    }
                    break;
                case 2094:
                    if (strM4357w1.equals("AO")) {
                        c = 7;
                    }
                    break;
                case 2096:
                    if (strM4357w1.equals("AQ")) {
                        c = '\b';
                    }
                    break;
                case 2097:
                    if (strM4357w1.equals("AR")) {
                        c = '\t';
                    }
                    break;
                case 2098:
                    if (strM4357w1.equals("AS")) {
                        c = '\n';
                    }
                    break;
                case 2099:
                    if (strM4357w1.equals("AT")) {
                        c = 11;
                    }
                    break;
                case 2100:
                    if (strM4357w1.equals("AU")) {
                        c = '\f';
                    }
                    break;
                case 2102:
                    if (strM4357w1.equals("AW")) {
                        c = '\r';
                    }
                    break;
                case 2103:
                    if (strM4357w1.equals("AX")) {
                        c = 14;
                    }
                    break;
                case 2105:
                    if (strM4357w1.equals("AZ")) {
                        c = 15;
                    }
                    break;
                case 2111:
                    if (strM4357w1.equals("BA")) {
                        c = 16;
                    }
                    break;
                case 2112:
                    if (strM4357w1.equals("BB")) {
                        c = 17;
                    }
                    break;
                case 2114:
                    if (strM4357w1.equals("BD")) {
                        c = 18;
                    }
                    break;
                case 2115:
                    if (strM4357w1.equals("BE")) {
                        c = 19;
                    }
                    break;
                case 2116:
                    if (strM4357w1.equals("BF")) {
                        c = 20;
                    }
                    break;
                case 2117:
                    if (strM4357w1.equals("BG")) {
                        c = 21;
                    }
                    break;
                case 2118:
                    if (strM4357w1.equals("BH")) {
                        c = 22;
                    }
                    break;
                case 2119:
                    if (strM4357w1.equals("BI")) {
                        c = 23;
                    }
                    break;
                case 2120:
                    if (strM4357w1.equals("BJ")) {
                        c = 24;
                    }
                    break;
                case 2122:
                    if (strM4357w1.equals("BL")) {
                        c = 25;
                    }
                    break;
                case 2123:
                    if (strM4357w1.equals("BM")) {
                        c = 26;
                    }
                    break;
                case 2124:
                    if (strM4357w1.equals("BN")) {
                        c = 27;
                    }
                    break;
                case 2125:
                    if (strM4357w1.equals("BO")) {
                        c = 28;
                    }
                    break;
                case 2127:
                    if (strM4357w1.equals("BQ")) {
                        c = 29;
                    }
                    break;
                case 2128:
                    if (strM4357w1.equals("BR")) {
                        c = 30;
                    }
                    break;
                case 2129:
                    if (strM4357w1.equals("BS")) {
                        c = 31;
                    }
                    break;
                case 2130:
                    if (strM4357w1.equals("BT")) {
                        c = ' ';
                    }
                    break;
                case 2133:
                    if (strM4357w1.equals("BW")) {
                        c = '!';
                    }
                    break;
                case 2135:
                    if (strM4357w1.equals("BY")) {
                        c = '\"';
                    }
                    break;
                case 2136:
                    if (strM4357w1.equals("BZ")) {
                        c = MentionUtils.CHANNELS_CHAR;
                    }
                    break;
                case 2142:
                    if (strM4357w1.equals("CA")) {
                        c = '$';
                    }
                    break;
                case 2145:
                    if (strM4357w1.equals("CD")) {
                        c = '%';
                    }
                    break;
                case 2147:
                    if (strM4357w1.equals("CF")) {
                        c = '&';
                    }
                    break;
                case 2148:
                    if (strM4357w1.equals("CG")) {
                        c = '\'';
                    }
                    break;
                case 2149:
                    if (strM4357w1.equals("CH")) {
                        c = '(';
                    }
                    break;
                case 2150:
                    if (strM4357w1.equals("CI")) {
                        c = ')';
                    }
                    break;
                case 2152:
                    if (strM4357w1.equals("CK")) {
                        c = '*';
                    }
                    break;
                case 2153:
                    if (strM4357w1.equals("CL")) {
                        c = '+';
                    }
                    break;
                case 2154:
                    if (strM4357w1.equals("CM")) {
                        c = ',';
                    }
                    break;
                case 2155:
                    if (strM4357w1.equals("CN")) {
                        c = '-';
                    }
                    break;
                case 2156:
                    if (strM4357w1.equals("CO")) {
                        c = '.';
                    }
                    break;
                case 2159:
                    if (strM4357w1.equals("CR")) {
                        c = MentionUtils.SLASH_CHAR;
                    }
                    break;
                case 2162:
                    if (strM4357w1.equals("CU")) {
                        c = '0';
                    }
                    break;
                case 2163:
                    if (strM4357w1.equals("CV")) {
                        c = '1';
                    }
                    break;
                case 2164:
                    if (strM4357w1.equals("CW")) {
                        c = '2';
                    }
                    break;
                case 2165:
                    if (strM4357w1.equals("CX")) {
                        c = '3';
                    }
                    break;
                case 2166:
                    if (strM4357w1.equals("CY")) {
                        c = '4';
                    }
                    break;
                case 2167:
                    if (strM4357w1.equals("CZ")) {
                        c = '5';
                    }
                    break;
                case 2177:
                    if (strM4357w1.equals("DE")) {
                        c = '6';
                    }
                    break;
                case 2182:
                    if (strM4357w1.equals("DJ")) {
                        c = '7';
                    }
                    break;
                case 2183:
                    if (strM4357w1.equals("DK")) {
                        c = '8';
                    }
                    break;
                case 2185:
                    if (strM4357w1.equals("DM")) {
                        c = '9';
                    }
                    break;
                case 2187:
                    if (strM4357w1.equals("DO")) {
                        c = MentionUtils.EMOJIS_AND_STICKERS_CHAR;
                    }
                    break;
                case 2198:
                    if (strM4357w1.equals("DZ")) {
                        c = ';';
                    }
                    break;
                case 2206:
                    if (strM4357w1.equals("EC")) {
                        c = '<';
                    }
                    break;
                case 2208:
                    if (strM4357w1.equals("EE")) {
                        c = '=';
                    }
                    break;
                case 2210:
                    if (strM4357w1.equals("EG")) {
                        c = '>';
                    }
                    break;
                case 2221:
                    if (strM4357w1.equals("ER")) {
                        c = '?';
                    }
                    break;
                case 2222:
                    if (strM4357w1.equals("ES")) {
                        c = MentionUtils.MENTIONS_CHAR;
                    }
                    break;
                case 2223:
                    if (strM4357w1.equals("ET")) {
                        c = 'A';
                    }
                    break;
                case 2243:
                    if (strM4357w1.equals("FI")) {
                        c = 'B';
                    }
                    break;
                case 2244:
                    if (strM4357w1.equals("FJ")) {
                        c = 'C';
                    }
                    break;
                case 2245:
                    if (strM4357w1.equals("FK")) {
                        c = 'D';
                    }
                    break;
                case 2247:
                    if (strM4357w1.equals("FM")) {
                        c = 'E';
                    }
                    break;
                case 2249:
                    if (strM4357w1.equals("FO")) {
                        c = 'F';
                    }
                    break;
                case 2252:
                    if (strM4357w1.equals("FR")) {
                        c = 'G';
                    }
                    break;
                case 2266:
                    if (strM4357w1.equals("GA")) {
                        c = 'H';
                    }
                    break;
                case 2267:
                    if (strM4357w1.equals("GB")) {
                        c = 'I';
                    }
                    break;
                case 2269:
                    if (strM4357w1.equals("GD")) {
                        c = 'J';
                    }
                    break;
                case 2270:
                    if (strM4357w1.equals("GE")) {
                        c = 'K';
                    }
                    break;
                case 2271:
                    if (strM4357w1.equals("GF")) {
                        c = 'L';
                    }
                    break;
                case 2272:
                    if (strM4357w1.equals("GG")) {
                        c = 'M';
                    }
                    break;
                case 2273:
                    if (strM4357w1.equals("GH")) {
                        c = 'N';
                    }
                    break;
                case 2274:
                    if (strM4357w1.equals("GI")) {
                        c = 'O';
                    }
                    break;
                case 2277:
                    if (strM4357w1.equals("GL")) {
                        c = 'P';
                    }
                    break;
                case 2278:
                    if (strM4357w1.equals("GM")) {
                        c = 'Q';
                    }
                    break;
                case 2279:
                    if (strM4357w1.equals("GN")) {
                        c = 'R';
                    }
                    break;
                case 2281:
                    if (strM4357w1.equals("GP")) {
                        c = 'S';
                    }
                    break;
                case 2282:
                    if (strM4357w1.equals("GQ")) {
                        c = 'T';
                    }
                    break;
                case 2283:
                    if (strM4357w1.equals("GR")) {
                        c = 'U';
                    }
                    break;
                case 2285:
                    if (strM4357w1.equals("GT")) {
                        c = 'V';
                    }
                    break;
                case 2286:
                    if (strM4357w1.equals("GU")) {
                        c = 'W';
                    }
                    break;
                case 2288:
                    if (strM4357w1.equals("GW")) {
                        c = 'X';
                    }
                    break;
                case 2290:
                    if (strM4357w1.equals("GY")) {
                        c = 'Y';
                    }
                    break;
                case 2307:
                    if (strM4357w1.equals("HK")) {
                        c = 'Z';
                    }
                    break;
                case 2310:
                    if (strM4357w1.equals("HN")) {
                        c = '[';
                    }
                    break;
                case 2314:
                    if (strM4357w1.equals("HR")) {
                        c = '\\';
                    }
                    break;
                case 2316:
                    if (strM4357w1.equals("HT")) {
                        c = ']';
                    }
                    break;
                case 2317:
                    if (strM4357w1.equals("HU")) {
                        c = '^';
                    }
                    break;
                case 2331:
                    if (strM4357w1.equals("ID")) {
                        c = '_';
                    }
                    break;
                case 2332:
                    if (strM4357w1.equals("IE")) {
                        c = '`';
                    }
                    break;
                case 2339:
                    if (strM4357w1.equals("IL")) {
                        c = 'a';
                    }
                    break;
                case 2340:
                    if (strM4357w1.equals("IM")) {
                        c = 'b';
                    }
                    break;
                case 2341:
                    if (strM4357w1.equals("IN")) {
                        c = 'c';
                    }
                    break;
                case 2342:
                    if (strM4357w1.equals("IO")) {
                        c = 'd';
                    }
                    break;
                case 2344:
                    if (strM4357w1.equals("IQ")) {
                        c = 'e';
                    }
                    break;
                case 2345:
                    if (strM4357w1.equals("IR")) {
                        c = 'f';
                    }
                    break;
                case 2346:
                    if (strM4357w1.equals("IS")) {
                        c = 'g';
                    }
                    break;
                case 2347:
                    if (strM4357w1.equals("IT")) {
                        c = 'h';
                    }
                    break;
                case 2363:
                    if (strM4357w1.equals("JE")) {
                        c = 'i';
                    }
                    break;
                case 2371:
                    if (strM4357w1.equals("JM")) {
                        c = 'j';
                    }
                    break;
                case 2373:
                    if (strM4357w1.equals("JO")) {
                        c = 'k';
                    }
                    break;
                case 2374:
                    if (strM4357w1.equals("JP")) {
                        c = 'l';
                    }
                    break;
                case 2394:
                    if (strM4357w1.equals("KE")) {
                        c = 'm';
                    }
                    break;
                case 2396:
                    if (strM4357w1.equals("KG")) {
                        c = 'n';
                    }
                    break;
                case 2397:
                    if (strM4357w1.equals("KH")) {
                        c = 'o';
                    }
                    break;
                case 2398:
                    if (strM4357w1.equals("KI")) {
                        c = 'p';
                    }
                    break;
                case 2402:
                    if (strM4357w1.equals("KM")) {
                        c = 'q';
                    }
                    break;
                case 2405:
                    if (strM4357w1.equals("KP")) {
                        c = 'r';
                    }
                    break;
                case 2407:
                    if (strM4357w1.equals("KR")) {
                        c = 's';
                    }
                    break;
                case 2412:
                    if (strM4357w1.equals("KW")) {
                        c = 't';
                    }
                    break;
                case 2414:
                    if (strM4357w1.equals("KY")) {
                        c = 'u';
                    }
                    break;
                case 2415:
                    if (strM4357w1.equals("KZ")) {
                        c = 'v';
                    }
                    break;
                case 2421:
                    if (strM4357w1.equals("LA")) {
                        c = 'w';
                    }
                    break;
                case 2422:
                    if (strM4357w1.equals("LB")) {
                        c = 'x';
                    }
                    break;
                case 2423:
                    if (strM4357w1.equals("LC")) {
                        c = 'y';
                    }
                    break;
                case 2429:
                    if (strM4357w1.equals("LI")) {
                        c = 'z';
                    }
                    break;
                case 2431:
                    if (strM4357w1.equals("LK")) {
                        c = '{';
                    }
                    break;
                case 2438:
                    if (strM4357w1.equals("LR")) {
                        c = '|';
                    }
                    break;
                case 2439:
                    if (strM4357w1.equals("LS")) {
                        c = '}';
                    }
                    break;
                case 2440:
                    if (strM4357w1.equals("LT")) {
                        c = '~';
                    }
                    break;
                case 2441:
                    if (strM4357w1.equals("LU")) {
                        c = 127;
                    }
                    break;
                case 2442:
                    if (strM4357w1.equals("LV")) {
                        c = 128;
                    }
                    break;
                case 2445:
                    if (strM4357w1.equals("LY")) {
                        c = 129;
                    }
                    break;
                case 2452:
                    if (strM4357w1.equals("MA")) {
                        c = 130;
                    }
                    break;
                case 2454:
                    if (strM4357w1.equals("MC")) {
                        c = 131;
                    }
                    break;
                case 2455:
                    if (strM4357w1.equals("MD")) {
                        c = 132;
                    }
                    break;
                case 2456:
                    if (strM4357w1.equals("ME")) {
                        c = 133;
                    }
                    break;
                case 2457:
                    if (strM4357w1.equals("MF")) {
                        c = 134;
                    }
                    break;
                case 2458:
                    if (strM4357w1.equals("MG")) {
                        c = 135;
                    }
                    break;
                case 2459:
                    if (strM4357w1.equals("MH")) {
                        c = 136;
                    }
                    break;
                case 2462:
                    if (strM4357w1.equals("MK")) {
                        c = 137;
                    }
                    break;
                case 2463:
                    if (strM4357w1.equals("ML")) {
                        c = 138;
                    }
                    break;
                case 2464:
                    if (strM4357w1.equals("MM")) {
                        c = 139;
                    }
                    break;
                case 2465:
                    if (strM4357w1.equals("MN")) {
                        c = 140;
                    }
                    break;
                case 2466:
                    if (strM4357w1.equals("MO")) {
                        c = 141;
                    }
                    break;
                case 2467:
                    if (strM4357w1.equals("MP")) {
                        c = 142;
                    }
                    break;
                case 2468:
                    if (strM4357w1.equals("MQ")) {
                        c = 143;
                    }
                    break;
                case 2469:
                    if (strM4357w1.equals("MR")) {
                        c = 144;
                    }
                    break;
                case 2470:
                    if (strM4357w1.equals("MS")) {
                        c = 145;
                    }
                    break;
                case 2471:
                    if (strM4357w1.equals("MT")) {
                        c = 146;
                    }
                    break;
                case 2472:
                    if (strM4357w1.equals("MU")) {
                        c = 147;
                    }
                    break;
                case 2473:
                    if (strM4357w1.equals("MV")) {
                        c = 148;
                    }
                    break;
                case 2474:
                    if (strM4357w1.equals("MW")) {
                        c = 149;
                    }
                    break;
                case 2475:
                    if (strM4357w1.equals("MX")) {
                        c = 150;
                    }
                    break;
                case 2476:
                    if (strM4357w1.equals("MY")) {
                        c = 151;
                    }
                    break;
                case 2477:
                    if (strM4357w1.equals("MZ")) {
                        c = 152;
                    }
                    break;
                case 2483:
                    if (strM4357w1.equals("NA")) {
                        c = 153;
                    }
                    break;
                case 2485:
                    if (strM4357w1.equals("NC")) {
                        c = 154;
                    }
                    break;
                case 2487:
                    if (strM4357w1.equals("NE")) {
                        c = 155;
                    }
                    break;
                case 2489:
                    if (strM4357w1.equals("NG")) {
                        c = 156;
                    }
                    break;
                case 2491:
                    if (strM4357w1.equals("NI")) {
                        c = 157;
                    }
                    break;
                case 2494:
                    if (strM4357w1.equals("NL")) {
                        c = 158;
                    }
                    break;
                case 2497:
                    if (strM4357w1.equals("NO")) {
                        c = 159;
                    }
                    break;
                case 2498:
                    if (strM4357w1.equals("NP")) {
                        c = 160;
                    }
                    break;
                case 2500:
                    if (strM4357w1.equals("NR")) {
                        c = 161;
                    }
                    break;
                case 2503:
                    if (strM4357w1.equals("NU")) {
                        c = 162;
                    }
                    break;
                case 2508:
                    if (strM4357w1.equals("NZ")) {
                        c = 163;
                    }
                    break;
                case 2526:
                    if (strM4357w1.equals("OM")) {
                        c = 164;
                    }
                    break;
                case 2545:
                    if (strM4357w1.equals("PA")) {
                        c = 165;
                    }
                    break;
                case 2549:
                    if (strM4357w1.equals("PE")) {
                        c = 166;
                    }
                    break;
                case 2550:
                    if (strM4357w1.equals("PF")) {
                        c = 167;
                    }
                    break;
                case 2551:
                    if (strM4357w1.equals("PG")) {
                        c = 168;
                    }
                    break;
                case 2552:
                    if (strM4357w1.equals("PH")) {
                        c = 169;
                    }
                    break;
                case 2555:
                    if (strM4357w1.equals("PK")) {
                        c = 170;
                    }
                    break;
                case 2556:
                    if (strM4357w1.equals("PL")) {
                        c = 171;
                    }
                    break;
                case 2557:
                    if (strM4357w1.equals("PM")) {
                        c = 172;
                    }
                    break;
                case 2562:
                    if (strM4357w1.equals("PR")) {
                        c = 173;
                    }
                    break;
                case 2563:
                    if (strM4357w1.equals("PS")) {
                        c = 174;
                    }
                    break;
                case 2564:
                    if (strM4357w1.equals("PT")) {
                        c = 175;
                    }
                    break;
                case 2567:
                    if (strM4357w1.equals("PW")) {
                        c = 176;
                    }
                    break;
                case 2569:
                    if (strM4357w1.equals("PY")) {
                        c = 177;
                    }
                    break;
                case 2576:
                    if (strM4357w1.equals("QA")) {
                        c = 178;
                    }
                    break;
                case 2611:
                    if (strM4357w1.equals("RE")) {
                        c = 179;
                    }
                    break;
                case 2621:
                    if (strM4357w1.equals("RO")) {
                        c = 180;
                    }
                    break;
                case 2625:
                    if (strM4357w1.equals("RS")) {
                        c = 181;
                    }
                    break;
                case 2627:
                    if (strM4357w1.equals("RU")) {
                        c = 182;
                    }
                    break;
                case 2629:
                    if (strM4357w1.equals("RW")) {
                        c = 183;
                    }
                    break;
                case 2638:
                    if (strM4357w1.equals("SA")) {
                        c = 184;
                    }
                    break;
                case 2639:
                    if (strM4357w1.equals("SB")) {
                        c = 185;
                    }
                    break;
                case 2640:
                    if (strM4357w1.equals("SC")) {
                        c = 186;
                    }
                    break;
                case 2641:
                    if (strM4357w1.equals("SD")) {
                        c = 187;
                    }
                    break;
                case 2642:
                    if (strM4357w1.equals("SE")) {
                        c = 188;
                    }
                    break;
                case 2644:
                    if (strM4357w1.equals("SG")) {
                        c = 189;
                    }
                    break;
                case 2645:
                    if (strM4357w1.equals("SH")) {
                        c = 190;
                    }
                    break;
                case 2646:
                    if (strM4357w1.equals("SI")) {
                        c = 191;
                    }
                    break;
                case 2647:
                    if (strM4357w1.equals("SJ")) {
                        c = 192;
                    }
                    break;
                case 2648:
                    if (strM4357w1.equals("SK")) {
                        c = 193;
                    }
                    break;
                case 2649:
                    if (strM4357w1.equals("SL")) {
                        c = 194;
                    }
                    break;
                case 2650:
                    if (strM4357w1.equals("SM")) {
                        c = 195;
                    }
                    break;
                case 2651:
                    if (strM4357w1.equals("SN")) {
                        c = 196;
                    }
                    break;
                case 2652:
                    if (strM4357w1.equals("SO")) {
                        c = 197;
                    }
                    break;
                case 2655:
                    if (strM4357w1.equals("SR")) {
                        c = 198;
                    }
                    break;
                case 2656:
                    if (strM4357w1.equals("SS")) {
                        c = 199;
                    }
                    break;
                case 2657:
                    if (strM4357w1.equals("ST")) {
                        c = 200;
                    }
                    break;
                case 2659:
                    if (strM4357w1.equals("SV")) {
                        c = 201;
                    }
                    break;
                case 2661:
                    if (strM4357w1.equals("SX")) {
                        c = 202;
                    }
                    break;
                case 2662:
                    if (strM4357w1.equals("SY")) {
                        c = 203;
                    }
                    break;
                case 2663:
                    if (strM4357w1.equals("SZ")) {
                        c = 204;
                    }
                    break;
                case 2671:
                    if (strM4357w1.equals("TC")) {
                        c = 205;
                    }
                    break;
                case 2672:
                    if (strM4357w1.equals("TD")) {
                        c = 206;
                    }
                    break;
                case 2675:
                    if (strM4357w1.equals("TG")) {
                        c = 207;
                    }
                    break;
                case 2676:
                    if (strM4357w1.equals("TH")) {
                        c = 208;
                    }
                    break;
                case 2678:
                    if (strM4357w1.equals("TJ")) {
                        c = 209;
                    }
                    break;
                case 2680:
                    if (strM4357w1.equals("TL")) {
                        c = 210;
                    }
                    break;
                case 2681:
                    if (strM4357w1.equals("TM")) {
                        c = 211;
                    }
                    break;
                case 2682:
                    if (strM4357w1.equals("TN")) {
                        c = 212;
                    }
                    break;
                case 2683:
                    if (strM4357w1.equals("TO")) {
                        c = 213;
                    }
                    break;
                case 2686:
                    if (strM4357w1.equals("TR")) {
                        c = 214;
                    }
                    break;
                case 2688:
                    if (strM4357w1.equals("TT")) {
                        c = 215;
                    }
                    break;
                case 2690:
                    if (strM4357w1.equals("TV")) {
                        c = 216;
                    }
                    break;
                case 2691:
                    if (strM4357w1.equals("TW")) {
                        c = 217;
                    }
                    break;
                case 2694:
                    if (strM4357w1.equals("TZ")) {
                        c = 218;
                    }
                    break;
                case 2700:
                    if (strM4357w1.equals("UA")) {
                        c = 219;
                    }
                    break;
                case 2706:
                    if (strM4357w1.equals("UG")) {
                        c = 220;
                    }
                    break;
                case 2718:
                    if (strM4357w1.equals("US")) {
                        c = 221;
                    }
                    break;
                case 2724:
                    if (strM4357w1.equals("UY")) {
                        c = 222;
                    }
                    break;
                case 2725:
                    if (strM4357w1.equals("UZ")) {
                        c = 223;
                    }
                    break;
                case 2733:
                    if (strM4357w1.equals("VC")) {
                        c = 224;
                    }
                    break;
                case 2735:
                    if (strM4357w1.equals("VE")) {
                        c = 225;
                    }
                    break;
                case 2737:
                    if (strM4357w1.equals("VG")) {
                        c = 226;
                    }
                    break;
                case 2739:
                    if (strM4357w1.equals("VI")) {
                        c = 227;
                    }
                    break;
                case 2744:
                    if (strM4357w1.equals("VN")) {
                        c = 228;
                    }
                    break;
                case 2751:
                    if (strM4357w1.equals("VU")) {
                        c = 229;
                    }
                    break;
                case 2767:
                    if (strM4357w1.equals("WF")) {
                        c = 230;
                    }
                    break;
                case 2780:
                    if (strM4357w1.equals("WS")) {
                        c = 231;
                    }
                    break;
                case 2803:
                    if (strM4357w1.equals("XK")) {
                        c = 232;
                    }
                    break;
                case 2828:
                    if (strM4357w1.equals("YE")) {
                        c = 233;
                    }
                    break;
                case 2843:
                    if (strM4357w1.equals("YT")) {
                        c = 234;
                    }
                    break;
                case 2855:
                    if (strM4357w1.equals("ZA")) {
                        c = 235;
                    }
                    break;
                case 2867:
                    if (strM4357w1.equals("ZM")) {
                        c = 236;
                    }
                    break;
                case 2877:
                    if (strM4357w1.equals("ZW")) {
                        c = 237;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case 26:
                case 'P':
                case 'y':
                    iArr = new int[]{1, 2, 0, 0, 2, 2};
                    break;
                case 1:
                    iArr = new int[]{1, 4, 4, 4, 3, 2};
                    break;
                case 2:
                case ']':
                case 155:
                case Opcodes.NEW /* 187 */:
                case 196:
                case 206:
                case HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION /* 225 */:
                case 233:
                    iArr = new int[]{4, 4, 4, 4, 2, 2};
                    break;
                case 3:
                    iArr = new int[]{2, 3, 1, 2, 2, 2};
                    break;
                case 4:
                case 25:
                case '3':
                case '9':
                case 'J':
                case Opcodes.I2B /* 145 */:
                case 224:
                    iArr = new int[]{1, 2, 2, 2, 2, 2};
                    break;
                case 5:
                case 16:
                case 'u':
                    iArr = new int[]{1, 2, 0, 1, 2, 2};
                    break;
                case 6:
                    iArr = new int[]{2, 3, 2, 4, 2, 2};
                    break;
                case 7:
                case ',':
                    iArr = new int[]{3, 4, 3, 2, 2, 2};
                    break;
                case '\b':
                case '?':
                case 'd':
                case Opcodes.IF_ICMPGE /* 162 */:
                case Opcodes.ARRAYLENGTH /* 190 */:
                case Opcodes.IFNONNULL /* 199 */:
                case 216:
                    iArr = new int[]{4, 2, 2, 2, 2, 2};
                    break;
                case '\t':
                    iArr = new int[]{2, 4, 1, 1, 2, 2};
                    break;
                case '\n':
                    iArr = new int[]{2, 2, 2, 3, 2, 2};
                    break;
                case 11:
                case '(':
                case 'g':
                case Opcodes.NEWARRAY /* 188 */:
                case Opcodes.INSTANCEOF /* 193 */:
                    iArr = new int[]{0, 0, 0, 0, 0, 2};
                    break;
                case '\f':
                    iArr = new int[]{0, 1, 0, 1, 2, 2};
                    break;
                case '\r':
                case 'W':
                    iArr = new int[]{1, 2, 4, 4, 2, 2};
                    break;
                case 14:
                case 'O':
                case 'z':
                case Opcodes.D2I /* 142 */:
                case Opcodes.IRETURN /* 172 */:
                case Opcodes.CHECKCAST /* 192 */:
                case Opcodes.MONITOREXIT /* 195 */:
                    iArr = new int[]{0, 2, 2, 2, 2, 2};
                    break;
                case 15:
                case 154:
                    iArr = new int[]{3, 2, 4, 4, 2, 2};
                    break;
                case 17:
                case 'F':
                case 'M':
                    iArr = new int[]{0, 2, 0, 0, 2, 2};
                    break;
                case 18:
                case Opcodes.DCMPL /* 151 */:
                    iArr = new int[]{2, 1, 3, 3, 2, 2};
                    break;
                case 19:
                    iArr = new int[]{0, 0, 3, 3, 2, 2};
                    break;
                case 20:
                    iArr = new int[]{4, 3, 4, 3, 2, 2};
                    break;
                case 21:
                case '5':
                case Opcodes.ATHROW /* 191 */:
                    iArr = new int[]{0, 0, 0, 0, 1, 2};
                    break;
                case 22:
                    iArr = new int[]{1, 2, 2, 4, 4, 2};
                    break;
                case 23:
                case ';':
                case 203:
                case 210:
                    iArr = new int[]{4, 3, 4, 4, 2, 2};
                    break;
                case 24:
                    iArr = new int[]{4, 4, 3, 4, 2, 2};
                    break;
                case 27:
                    iArr = new int[]{3, 2, 1, 1, 2, 2};
                    break;
                case 28:
                    iArr = new int[]{1, 3, 3, 2, 2, 2};
                    break;
                case 29:
                    iArr = new int[]{1, 2, 2, 0, 2, 2};
                    break;
                case 30:
                case Opcodes.IFNULL /* 198 */:
                    iArr = new int[]{2, 3, 2, 2, 2, 2};
                    break;
                case 31:
                    iArr = new int[]{4, 2, 2, 3, 2, 2};
                    break;
                case ' ':
                    iArr = new int[]{3, 1, 3, 2, 2, 2};
                    break;
                case '!':
                case 'Y':
                    iArr = new int[]{3, 4, 1, 0, 2, 2};
                    break;
                case '\"':
                    iArr = new int[]{0, 1, 1, 3, 2, 2};
                    break;
                case '#':
                    iArr = new int[]{2, 4, 2, 2, 2, 2};
                    break;
                case '$':
                    iArr = new int[]{0, 2, 1, 2, 4, 1};
                    break;
                case '%':
                    iArr = new int[]{4, 2, 3, 1, 2, 2};
                    break;
                case '&':
                    iArr = new int[]{4, 2, 3, 2, 2, 2};
                    break;
                case '\'':
                case 150:
                    iArr = new int[]{2, 4, 3, 4, 2, 2};
                    break;
                case ')':
                    iArr = new int[]{3, 3, 3, 4, 2, 2};
                    break;
                case '*':
                    iArr = new int[]{2, 2, 2, 1, 2, 2};
                    break;
                case '+':
                case Opcodes.LOOKUPSWITCH /* 171 */:
                case 221:
                    iArr = new int[]{1, 1, 2, 2, 3, 2};
                    break;
                case '-':
                    iArr = new int[]{2, 0, 2, 2, 3, 1};
                    break;
                case '.':
                    iArr = new int[]{2, 2, 4, 2, 2, 2};
                    break;
                case '/':
                    iArr = new int[]{2, 2, 4, 4, 2, 2};
                    break;
                case '0':
                case Opcodes.JSR /* 168 */:
                    iArr = new int[]{4, 4, 3, 2, 2, 2};
                    break;
                case '1':
                    iArr = new int[]{2, 3, 1, 0, 2, 2};
                    break;
                case '2':
                    iArr = new int[]{2, 2, 0, 0, 2, 2};
                    break;
                case '4':
                    iArr = new int[]{1, 0, 0, 0, 1, 2};
                    break;
                case '6':
                    iArr = new int[]{0, 0, 2, 2, 1, 2};
                    break;
                case '7':
                    iArr = new int[]{4, 1, 4, 4, 2, 2};
                    break;
                case '8':
                    iArr = new int[]{0, 0, 1, 0, 0, 2};
                    break;
                case ':':
                case 'j':
                    iArr = new int[]{3, 4, 4, 4, 2, 2};
                    break;
                case '<':
                    iArr = new int[]{2, 4, 2, 1, 2, 2};
                    break;
                case '=':
                case '~':
                case 128:
                case Opcodes.I2C /* 146 */:
                    iArr = new int[]{0, 0, 0, 0, 2, 2};
                    break;
                case '>':
                    iArr = new int[]{3, 4, 2, 3, 2, 2};
                    break;
                case '@':
                case '`':
                    iArr = new int[]{0, 1, 1, 1, 2, 2};
                    break;
                case 'A':
                    iArr = new int[]{4, 4, 3, 1, 2, 2};
                    break;
                case 'B':
                    iArr = new int[]{0, 0, 0, 1, 0, 2};
                    break;
                case 'C':
                    iArr = new int[]{3, 1, 3, 3, 2, 2};
                    break;
                case 'D':
                case 'r':
                case 130:
                case Opcodes.DCMPG /* 152 */:
                case 200:
                    iArr = new int[]{3, 2, 2, 2, 2, 2};
                    break;
                case 'E':
                    iArr = new int[]{3, 2, 4, 2, 2, 2};
                    break;
                case 'G':
                    iArr = new int[]{1, 1, 2, 1, 1, 1};
                    break;
                case 'H':
                    iArr = new int[]{2, 3, 1, 1, 2, 2};
                    break;
                case 'I':
                    iArr = new int[]{0, 0, 1, 1, 2, 3};
                    break;
                case 'K':
                    iArr = new int[]{1, 1, 1, 3, 2, 2};
                    break;
                case 'L':
                case 'S':
                case Opcodes.D2L /* 143 */:
                    iArr = new int[]{2, 1, 2, 3, 2, 2};
                    break;
                case 'N':
                    iArr = new int[]{3, 2, 3, 2, 2, 2};
                    break;
                case 'Q':
                case 230:
                    iArr = new int[]{4, 2, 2, 4, 2, 2};
                    break;
                case 'R':
                    iArr = new int[]{4, 3, 4, 2, 2, 2};
                    break;
                case 'T':
                    iArr = new int[]{4, 2, 3, 4, 2, 2};
                    break;
                case 'U':
                case '\\':
                case Opcodes.IINC /* 132 */:
                case Opcodes.L2F /* 137 */:
                case Opcodes.PUTFIELD /* 181 */:
                    iArr = new int[]{1, 0, 0, 0, 2, 2};
                    break;
                case 'V':
                    iArr = new int[]{2, 3, 2, 1, 2, 2};
                    break;
                case 'X':
                case 218:
                    iArr = new int[]{3, 4, 3, 3, 2, 2};
                    break;
                case 'Z':
                    iArr = new int[]{0, 1, 2, 3, 2, 0};
                    break;
                case '[':
                case Opcodes.TABLESWITCH /* 170 */:
                case Opcodes.MULTIANEWARRAY /* 197 */:
                    iArr = new int[]{3, 2, 3, 3, 2, 2};
                    break;
                case '^':
                    iArr = new int[]{0, 0, 0, 1, 3, 2};
                    break;
                case '_':
                    iArr = new int[]{3, 2, 3, 3, 3, 2};
                    break;
                case 'a':
                    iArr = new int[]{1, 1, 2, 3, 4, 2};
                    break;
                case 'b':
                    iArr = new int[]{0, 2, 0, 1, 2, 2};
                    break;
                case 'c':
                    iArr = new int[]{1, 1, 3, 2, 4, 3};
                    break;
                case 'e':
                case 220:
                    iArr = new int[]{3, 3, 3, 3, 2, 2};
                    break;
                case 'f':
                    iArr = new int[]{3, 0, 1, 1, 3, 0};
                    break;
                case 'h':
                    iArr = new int[]{0, 1, 0, 1, 1, 2};
                    break;
                case 'i':
                    iArr = new int[]{3, 2, 1, 2, 2, 2};
                    break;
                case 'k':
                case Opcodes.I2L /* 133 */:
                    iArr = new int[]{1, 0, 0, 1, 2, 2};
                    break;
                case 'l':
                    iArr = new int[]{0, 1, 0, 1, 1, 1};
                    break;
                case 'm':
                    iArr = new int[]{3, 3, 2, 2, 2, 2};
                    break;
                case 'n':
                    iArr = new int[]{2, 1, 1, 1, 2, 2};
                    break;
                case 'o':
                    iArr = new int[]{1, 1, 4, 2, 2, 2};
                    break;
                case 'p':
                case 'q':
                case Opcodes.LOR /* 129 */:
                case Opcodes.INVOKEINTERFACE /* 185 */:
                    iArr = new int[]{4, 2, 4, 3, 2, 2};
                    break;
                case 's':
                    iArr = new int[]{0, 0, 1, 3, 4, 4};
                    break;
                case 't':
                    iArr = new int[]{1, 1, 0, 0, 0, 2};
                    break;
                case 'v':
                    iArr = new int[]{1, 1, 2, 2, 2, 2};
                    break;
                case 'w':
                case 222:
                    iArr = new int[]{2, 2, 1, 2, 2, 2};
                    break;
                case 'x':
                    iArr = new int[]{3, 2, 1, 4, 2, 2};
                    break;
                case '{':
                    iArr = new int[]{3, 1, 3, 4, 4, 2};
                    break;
                case '|':
                    iArr = new int[]{3, 4, 4, 3, 2, 2};
                    break;
                case Opcodes.LUSHR /* 125 */:
                    iArr = new int[]{3, 3, 4, 3, 2, 2};
                    break;
                case Opcodes.LAND /* 127 */:
                    iArr = new int[]{1, 0, 2, 2, 2, 2};
                    break;
                case Opcodes.LXOR /* 131 */:
                    iArr = new int[]{0, 2, 2, 0, 2, 2};
                    break;
                case Opcodes.I2F /* 134 */:
                    iArr = new int[]{1, 2, 1, 0, 2, 2};
                    break;
                case Opcodes.I2D /* 135 */:
                    iArr = new int[]{3, 4, 2, 2, 2, 2};
                    break;
                case Opcodes.L2I /* 136 */:
                    iArr = new int[]{3, 2, 2, 4, 2, 2};
                    break;
                case Opcodes.L2D /* 138 */:
                    iArr = new int[]{4, 3, 3, 1, 2, 2};
                    break;
                case Opcodes.F2I /* 139 */:
                    iArr = new int[]{2, 4, 3, 3, 2, 2};
                    break;
                case Opcodes.F2L /* 140 */:
                    iArr = new int[]{2, 0, 1, 2, 2, 2};
                    break;
                case Opcodes.F2D /* 141 */:
                    iArr = new int[]{0, 2, 4, 4, 2, 2};
                    break;
                case Opcodes.D2F /* 144 */:
                    iArr = new int[]{4, 1, 3, 4, 2, 2};
                    break;
                case Opcodes.I2S /* 147 */:
                    iArr = new int[]{3, 1, 1, 2, 2, 2};
                    break;
                case Opcodes.LCMP /* 148 */:
                    iArr = new int[]{3, 4, 1, 4, 2, 2};
                    break;
                case Opcodes.FCMPL /* 149 */:
                    iArr = new int[]{4, 2, 1, 0, 2, 2};
                    break;
                case 153:
                    iArr = new int[]{4, 3, 2, 2, 2, 2};
                    break;
                case 156:
                    iArr = new int[]{3, 4, 1, 1, 2, 2};
                    break;
                case 157:
                    iArr = new int[]{2, 3, 4, 3, 2, 2};
                    break;
                case 158:
                    iArr = new int[]{0, 0, 3, 2, 0, 4};
                    break;
                case Opcodes.IF_ICMPEQ /* 159 */:
                    iArr = new int[]{0, 0, 2, 0, 0, 2};
                    break;
                case Opcodes.IF_ICMPNE /* 160 */:
                    iArr = new int[]{2, 1, 4, 3, 2, 2};
                    break;
                case Opcodes.IF_ICMPLT /* 161 */:
                    iArr = new int[]{3, 2, 2, 0, 2, 2};
                    break;
                case Opcodes.IF_ICMPGT /* 163 */:
                    iArr = new int[]{1, 0, 1, 2, 4, 2};
                    break;
                case Opcodes.IF_ICMPLE /* 164 */:
                    iArr = new int[]{2, 3, 1, 3, 4, 2};
                    break;
                case Opcodes.IF_ACMPEQ /* 165 */:
                    iArr = new int[]{1, 3, 3, 3, 2, 2};
                    break;
                case Opcodes.IF_ACMPNE /* 166 */:
                    iArr = new int[]{2, 3, 4, 4, 4, 2};
                    break;
                case Opcodes.GOTO /* 167 */:
                    iArr = new int[]{2, 3, 3, 1, 2, 2};
                    break;
                case Opcodes.RET /* 169 */:
                    iArr = new int[]{2, 2, 3, 3, 3, 2};
                    break;
                case Opcodes.LRETURN /* 173 */:
                    iArr = new int[]{2, 3, 2, 2, 3, 3};
                    break;
                case Opcodes.FRETURN /* 174 */:
                    iArr = new int[]{3, 4, 1, 2, 2, 2};
                    break;
                case 175:
                    iArr = new int[]{0, 1, 0, 0, 2, 2};
                    break;
                case Opcodes.ARETURN /* 176 */:
                    iArr = new int[]{2, 2, 4, 1, 2, 2};
                    break;
                case Opcodes.RETURN /* 177 */:
                    iArr = new int[]{2, 2, 3, 2, 2, 2};
                    break;
                case Opcodes.GETSTATIC /* 178 */:
                    iArr = new int[]{2, 4, 2, 4, 4, 2};
                    break;
                case Opcodes.PUTSTATIC /* 179 */:
                    iArr = new int[]{1, 1, 1, 2, 2, 2};
                    break;
                case 180:
                    iArr = new int[]{0, 0, 1, 1, 1, 2};
                    break;
                case Opcodes.INVOKEVIRTUAL /* 182 */:
                    iArr = new int[]{0, 0, 0, 1, 2, 2};
                    break;
                case Opcodes.INVOKESPECIAL /* 183 */:
                    iArr = new int[]{3, 4, 3, 0, 2, 2};
                    break;
                case Opcodes.INVOKESTATIC /* 184 */:
                case 212:
                case 226:
                    iArr = new int[]{2, 2, 1, 1, 2, 2};
                    break;
                case Opcodes.INVOKEDYNAMIC /* 186 */:
                    iArr = new int[]{4, 3, 0, 2, 2, 2};
                    break;
                case Opcodes.ANEWARRAY /* 189 */:
                    iArr = new int[]{1, 1, 2, 3, 1, 4};
                    break;
                case Opcodes.MONITORENTER /* 194 */:
                    iArr = new int[]{4, 3, 4, 1, 2, 2};
                    break;
                case 201:
                    iArr = new int[]{2, 2, 3, 3, 2, 2};
                    break;
                case 202:
                case 205:
                    iArr = new int[]{2, 2, 1, 0, 2, 2};
                    break;
                case 204:
                    iArr = new int[]{4, 3, 2, 4, 2, 2};
                    break;
                case 207:
                    iArr = new int[]{3, 3, 2, 0, 2, 2};
                    break;
                case 208:
                    iArr = new int[]{0, 3, 2, 3, 3, 0};
                    break;
                case 209:
                    iArr = new int[]{4, 2, 4, 4, 2, 2};
                    break;
                case 211:
                    iArr = new int[]{4, 2, 4, 2, 2, 2};
                    break;
                case 213:
                    iArr = new int[]{4, 2, 3, 3, 2, 2};
                    break;
                case 214:
                    iArr = new int[]{1, 1, 0, 1, 2, 2};
                    break;
                case 215:
                    iArr = new int[]{1, 4, 1, 1, 2, 2};
                    break;
                case 217:
                    iArr = new int[]{0, 0, 0, 0, 0, 0};
                    break;
                case 219:
                    iArr = new int[]{0, 3, 1, 1, 2, 2};
                    break;
                case 223:
                    iArr = new int[]{2, 2, 3, 4, 2, 2};
                    break;
                case 227:
                    iArr = new int[]{1, 2, 1, 3, 2, 2};
                    break;
                case 228:
                    iArr = new int[]{0, 3, 3, 4, 2, 2};
                    break;
                case 229:
                    iArr = new int[]{4, 2, 2, 1, 2, 2};
                    break;
                case 231:
                    iArr = new int[]{3, 1, 2, 1, 2, 2};
                    break;
                case 232:
                    iArr = new int[]{1, 1, 1, 1, 2, 2};
                    break;
                case 234:
                    iArr = new int[]{4, 1, 1, 1, 2, 2};
                    break;
                case 235:
                    iArr = new int[]{3, 3, 1, 1, 1, 2};
                    break;
                case 236:
                    iArr = new int[]{3, 3, 4, 2, 2, 2};
                    break;
                case 237:
                    iArr = new int[]{3, 2, 4, 3, 2, 2};
                    break;
                default:
                    iArr = new int[]{2, 2, 2, 2, 2, 2};
                    break;
            }
            HashMap map = new HashMap(8);
            map.put(0, 1000000L);
            ImmutableList2<Long> immutableList22 = DefaultBandwidthMeter.f6569a;
            map.put(2, immutableList22.get(iArr[0]));
            map.put(3, DefaultBandwidthMeter.f6570b.get(iArr[1]));
            map.put(4, DefaultBandwidthMeter.f6571c.get(iArr[2]));
            map.put(5, DefaultBandwidthMeter.f6572d.get(iArr[3]));
            map.put(10, DefaultBandwidthMeter.f6573e.get(iArr[4]));
            map.put(9, DefaultBandwidthMeter.f6574f.get(iArr[5]));
            map.put(7, immutableList22.get(iArr[0]));
            this.f6590b = map;
            this.f6591c = 2000;
            this.f6592d = Clock4.f6720a;
            this.f6593e = true;
        }
    }

    public DefaultBandwidthMeter(Context context, Map map, int i, Clock4 clock4, boolean z2, a aVar) {
        NetworkTypeObserver networkTypeObserver;
        int i2;
        this.f6576h = ImmutableMap2.m6273a(map);
        this.f6578j = new SlidingPercentile(i);
        this.f6579k = clock4;
        this.f6580l = z2;
        if (context == null) {
            this.f6584p = 0;
            this.f6587s = m2862h(0);
            return;
        }
        synchronized (NetworkTypeObserver.class) {
            if (NetworkTypeObserver.f6782a == null) {
                NetworkTypeObserver.f6782a = new NetworkTypeObserver(context);
            }
            networkTypeObserver = NetworkTypeObserver.f6782a;
        }
        synchronized (networkTypeObserver.f6785d) {
            i2 = networkTypeObserver.f6786e;
        }
        this.f6584p = i2;
        this.f6587s = m2862h(i2);
        C2681b c2681b = new C2681b(this);
        for (WeakReference<NetworkTypeObserver.b> weakReference : networkTypeObserver.f6784c) {
            if (weakReference.get() == null) {
                networkTypeObserver.f6784c.remove(weakReference);
            }
        }
        networkTypeObserver.f6784c.add(new WeakReference<>(c2681b));
        networkTypeObserver.f6783b.post(new RunnableC2733c(networkTypeObserver, c2681b));
    }

    /* renamed from: i */
    public static boolean m2861i(DataSpec dataSpec, boolean z2) {
        return z2 && !dataSpec.m2856c(8);
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.TransferListener
    /* renamed from: a */
    public synchronized void mo2773a(DataSource3 dataSource3, DataSpec dataSpec, boolean z2) {
        if (m2861i(dataSpec, z2)) {
            AnimatableValueParser.m426D(this.f6581m > 0);
            long jMo2952d = this.f6579k.mo2952d();
            int i = (int) (jMo2952d - this.f6582n);
            this.f6585q += i;
            long j = this.f6586r;
            long j2 = this.f6583o;
            this.f6586r = j + j2;
            if (i > 0) {
                this.f6578j.m2875a((int) Math.sqrt(j2), (j2 * 8000.0f) / i);
                if (this.f6585q >= 2000 || this.f6586r >= Permission.VIEW_GUILD_ANALYTICS) {
                    this.f6587s = (long) this.f6578j.m2876b(0.5f);
                }
                m2863j(i, this.f6583o, this.f6587s);
                this.f6582n = jMo2952d;
                this.f6583o = 0L;
            }
            this.f6581m--;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.TransferListener
    /* renamed from: b */
    public synchronized void mo2774b(DataSource3 dataSource3, DataSpec dataSpec, boolean z2) {
        if (m2861i(dataSpec, z2)) {
            if (this.f6581m == 0) {
                this.f6582n = this.f6579k.mo2952d();
            }
            this.f6581m++;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.BandwidthMeter
    /* renamed from: c */
    public TransferListener mo2844c() {
        return this;
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.BandwidthMeter
    /* renamed from: d */
    public void mo2845d(BandwidthMeter.a aVar) {
        this.f6577i.m2847a(aVar);
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.TransferListener
    /* renamed from: e */
    public synchronized void mo2775e(DataSource3 dataSource3, DataSpec dataSpec, boolean z2, int i) {
        if (m2861i(dataSpec, z2)) {
            this.f6583o += i;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.BandwidthMeter
    /* renamed from: f */
    public void mo2846f(Handler handler, BandwidthMeter.a aVar) {
        BandwidthMeter.a.C13224a c13224a = this.f6577i;
        Objects.requireNonNull(c13224a);
        c13224a.m2847a(aVar);
        c13224a.f6524a.add(new BandwidthMeter.a.C13224a.C13225a(handler, aVar));
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.TransferListener
    /* renamed from: g */
    public void mo2776g(DataSource3 dataSource3, DataSpec dataSpec, boolean z2) {
    }

    /* renamed from: h */
    public final long m2862h(int i) {
        Long l = this.f6576h.get(Integer.valueOf(i));
        if (l == null) {
            l = this.f6576h.get(0);
        }
        if (l == null) {
            l = 1000000L;
        }
        return l.longValue();
    }

    /* renamed from: j */
    public final void m2863j(int i, long j, long j2) {
        if (i == 0 && j == 0 && j2 == this.f6588t) {
            return;
        }
        this.f6588t = j2;
        for (BandwidthMeter.a.C13224a.C13225a c13225a : this.f6577i.f6524a) {
            if (!c13225a.f6527c) {
                c13225a.f6525a.post(new RunnableC2679a(c13225a, i, j, j2));
            }
        }
    }
}
