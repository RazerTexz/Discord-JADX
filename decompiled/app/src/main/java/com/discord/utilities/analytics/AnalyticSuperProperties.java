package com.discord.utilities.analytics;

import android.os.Build;
import com.discord.BuildConfig;
import com.discord.utilities.accessibility.AccessibilityFeatureFlags;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.properties.Interfaces;
import kotlin.reflect.KProperty;
import p507d0.Tuples;
import p507d0.p579g0.Strings4;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Maps6;
import p507d0.p580t.MapsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.MutablePropertyReference1Impl;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: AnalyticSuperProperties.kt */
/* loaded from: classes2.dex */
public final class AnalyticSuperProperties {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection2.mutableProperty1(new MutablePropertyReference1Impl(AnalyticSuperProperties.class, "superProperties", "getSuperProperties()Ljava/util/Map;", 0))};
    public static final AnalyticSuperProperties INSTANCE;
    private static final String PROPERTY_ACCESSIBILITY_FEATURES = "accessibility_features";
    private static final String PROPERTY_ACCESSIBILITY_SUPPORT_ENABLED = "accessibility_support_enabled";
    private static final String PROPERTY_BROWSER = "browser";
    private static final String PROPERTY_BROWSER_USER_AGENT = "browser_user_agent";
    private static final String PROPERTY_CLIENT_BUILD_NUMBER = "client_build_number";
    private static final String PROPERTY_CLIENT_PERFORMANCE_CPU = "client_performance_cpu";
    private static final String PROPERTY_CLIENT_PERFORMANCE_MEMORY = "client_performance_memory";
    private static final String PROPERTY_CLIENT_VERSION = "client_version";
    private static final String PROPERTY_CPU_CORE_COUNT = "cpu_core_count";
    private static final String PROPERTY_DEVICE = "device";
    private static final String PROPERTY_DEVICE_ADVERTISER_ID = "device_advertiser_id";
    private static final String PROPERTY_LOCATION = "location";
    private static final String PROPERTY_MP_KEYWORD = "mp_keyword";
    private static final String PROPERTY_OS = "os";
    private static final String PROPERTY_OS_SDK_VERSION = "os_sdk_version";
    private static final String PROPERTY_OS_VERSION = "os_version";
    private static final String PROPERTY_REFERRER = "referrer";
    private static final String PROPERTY_REFERRING_DOMAIN = "referring_domain";
    private static final String PROPERTY_SEARCH_ENGINE = "search_engine";
    private static final String PROPERTY_SYSTEM_LOCALE = "system_locale";
    private static final String PROPERTY_UTM_CAMPAIGN = "utm_campaign";
    private static final String PROPERTY_UTM_CONTENT = "utm_content";
    private static final String PROPERTY_UTM_MEDIUM = "utm_medium";
    private static final String PROPERTY_UTM_SOURCE = "utm_source";
    private static final String PROPERTY_UTM_TERM = "utm_term";

    /* renamed from: superProperties$delegate, reason: from kotlin metadata */
    private static final Interfaces superProperties;
    private static String superPropertiesString;
    private static String superPropertiesStringBase64;

    static {
        AnalyticSuperProperties analyticSuperProperties = new AnalyticSuperProperties();
        INSTANCE = analyticSuperProperties;
        superPropertiesString = "";
        superPropertiesStringBase64 = "";
        Map mapEmptyMap = Maps6.emptyMap();
        superProperties = new Delegates(mapEmptyMap, mapEmptyMap);
        analyticSuperProperties.setBaselineProperties();
    }

    private AnalyticSuperProperties() {
    }

    public static final /* synthetic */ String access$getSuperPropertiesString$p(AnalyticSuperProperties analyticSuperProperties) {
        return superPropertiesString;
    }

    public static final /* synthetic */ String access$getSuperPropertiesStringBase64$p(AnalyticSuperProperties analyticSuperProperties) {
        return superPropertiesStringBase64;
    }

    public static final /* synthetic */ void access$setSuperPropertiesString$p(AnalyticSuperProperties analyticSuperProperties, String str) {
        superPropertiesString = str;
    }

    public static final /* synthetic */ void access$setSuperPropertiesStringBase64$p(AnalyticSuperProperties analyticSuperProperties, String str) {
        superPropertiesStringBase64 = str;
    }

    private final void setBaselineProperties() {
        String string = Locale.getDefault().toString();
        Intrinsics3.checkNotNullExpressionValue(string, "Locale.getDefault().toString()");
        updateSuperProperties(Maps6.mapOf(Tuples.m10073to(PROPERTY_BROWSER, "Discord Android"), Tuples.m10073to(PROPERTY_BROWSER_USER_AGENT, BuildConfig.USER_AGENT), Tuples.m10073to(PROPERTY_CLIENT_BUILD_NUMBER, Integer.valueOf(BuildConfig.VERSION_CODE)), Tuples.m10073to(PROPERTY_CLIENT_VERSION, BuildConfig.VERSION_NAME), Tuples.m10073to(PROPERTY_DEVICE, Build.MODEL + ", " + Build.PRODUCT), Tuples.m10073to(PROPERTY_OS, "Android"), Tuples.m10073to(PROPERTY_OS_SDK_VERSION, String.valueOf(Build.VERSION.SDK_INT)), Tuples.m10073to(PROPERTY_OS_VERSION, Build.VERSION.RELEASE), Tuples.m10073to(PROPERTY_SYSTEM_LOCALE, StringsJVM.replace$default(string, "_", "-", false, 4, (Object) null))));
    }

    private final void setSuperProperties(Map<String, ? extends Object> map) {
        superProperties.setValue(this, $$delegatedProperties[0], map);
    }

    private final synchronized void updateSuperProperties(Map<String, ? extends Object> extraSuperProperties) {
        setSuperProperties(Maps6.plus(getSuperProperties(), extraSuperProperties));
    }

    public final Map<String, Object> getSuperProperties() {
        return (Map) superProperties.getValue(this, $$delegatedProperties[0]);
    }

    public final String getSuperPropertiesString() {
        return superPropertiesString;
    }

    public final String getSuperPropertiesStringBase64() {
        return superPropertiesStringBase64;
    }

    public final void setAccessibilityProperties(boolean accessibilitySupportEnabled, EnumSet<AccessibilityFeatureFlags> features) {
        Intrinsics3.checkNotNullParameter(features, "features");
        Iterator<T> it = features.iterator();
        long value = 0;
        while (it.hasNext()) {
            value |= ((AccessibilityFeatureFlags) it.next()).getValue();
        }
        updateSuperProperties(Maps6.mapOf(Tuples.m10073to(PROPERTY_ACCESSIBILITY_SUPPORT_ENABLED, Boolean.valueOf(accessibilitySupportEnabled)), Tuples.m10073to(PROPERTY_ACCESSIBILITY_FEATURES, Long.valueOf(value))));
    }

    public final void setAdvertiserId(String advertiserId) {
        Intrinsics3.checkNotNullParameter(advertiserId, "advertiserId");
        updateSuperProperties(MapsJVM.mapOf(Tuples.m10073to(PROPERTY_DEVICE_ADVERTISER_ID, advertiserId)));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setCampaignProperties(String referrerUrl) {
        boolean z2;
        Intrinsics3.checkNotNullParameter(referrerUrl, "referrerUrl");
        Map<String, ? extends Object> mapMutableMapOf = Maps6.mutableMapOf(Tuples.m10073to("referrer", referrerUrl));
        List listSplit$default = Strings4.split$default((CharSequence) referrerUrl, new String[]{"&"}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listSplit$default, 10));
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            arrayList.add(Strings4.split$default((CharSequence) it.next(), new String[]{"="}, false, 0, 6, (Object) null));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((List) obj).size() == 2) {
                arrayList2.add(obj);
            }
        }
        ArrayList<List> arrayList3 = new ArrayList();
        for (Object obj2 : arrayList2) {
            String str = (String) ((List) obj2).get(0);
            switch (str.hashCode()) {
                case -1539894552:
                    z2 = str.equals(PROPERTY_UTM_CONTENT);
                    break;
                case -1089678029:
                    if (str.equals(PROPERTY_REFERRING_DOMAIN)) {
                    }
                    break;
                case -64687999:
                    if (str.equals(PROPERTY_UTM_CAMPAIGN)) {
                    }
                    break;
                case 833459293:
                    if (str.equals(PROPERTY_UTM_TERM)) {
                    }
                    break;
                case 1027243853:
                    if (str.equals(PROPERTY_MP_KEYWORD)) {
                    }
                    break;
                case 1061643449:
                    if (str.equals(PROPERTY_SEARCH_ENGINE)) {
                    }
                    break;
                case 1889642278:
                    if (str.equals(PROPERTY_UTM_MEDIUM)) {
                    }
                    break;
                case 1901043637:
                    if (str.equals("location")) {
                    }
                    break;
                case 2071166924:
                    if (str.equals(PROPERTY_UTM_SOURCE)) {
                    }
                    break;
            }
            if (z2) {
                arrayList3.add(obj2);
            }
        }
        for (List list : arrayList3) {
            mapMutableMapOf.put((String) list.get(0), (String) list.get(1));
        }
        updateSuperProperties(mapMutableMapOf);
    }

    public final void setClientPerformanceProperties(int cpu, long memoryKb, int cpuCoreCount) {
        updateSuperProperties(Maps6.mapOf(Tuples.m10073to(PROPERTY_CLIENT_PERFORMANCE_CPU, Integer.valueOf(cpu)), Tuples.m10073to(PROPERTY_CLIENT_PERFORMANCE_MEMORY, Long.valueOf(memoryKb)), Tuples.m10073to(PROPERTY_CPU_CORE_COUNT, Integer.valueOf(cpuCoreCount))));
    }
}
