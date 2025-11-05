package com.discord.utilities.cache;

import android.content.SharedPreferences;
import androidx.exifinterface.media.ExifInterface;
import d0.g0.w;
import d0.t.h0;
import d0.t.n0;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: SharedPreferenceExtensions.kt */
/* loaded from: classes2.dex */
public final class SharedPreferenceExtensionsKt {

    /* JADX INFO: Add missing generic type declarations: [V] */
    /* compiled from: SharedPreferenceExtensions.kt */
    /* renamed from: com.discord.utilities.cache.SharedPreferenceExtensionsKt$putStringEntrySetAsMap$1, reason: invalid class name */
    public static final class AnonymousClass1<V> extends o implements Function1<V, String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(Object obj) {
            return invoke2((AnonymousClass1<V>) obj);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2(V v) {
            return String.valueOf(v);
        }
    }

    public static final String getString(SharedPreferences sharedPreferences, String str) {
        m.checkNotNullParameter(sharedPreferences, "$this$getString");
        m.checkNotNullParameter(str, "key");
        return sharedPreferences.getString(str, null);
    }

    public static final <K, V> Map<K, V> getStringEntrySetAsMap(SharedPreferences sharedPreferences, String str, String str2, Function2<? super String, ? super String, ? extends Pair<? extends K, ? extends V>> function2) {
        m.checkNotNullParameter(sharedPreferences, "$this$getStringEntrySetAsMap");
        m.checkNotNullParameter(str, "cacheKey");
        m.checkNotNullParameter(str2, "delimiter");
        m.checkNotNullParameter(function2, "transformer");
        Set stringSetNonNull$default = getStringSetNonNull$default(sharedPreferences, str, null, 2, null);
        HashMap map = new HashMap(stringSetNonNull$default.size());
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(stringSetNonNull$default, 10));
        Iterator it = stringSetNonNull$default.iterator();
        while (it.hasNext()) {
            List listSplit$default = w.split$default((CharSequence) it.next(), new String[]{str2}, false, 2, 2, (Object) null);
            arrayList.add(function2.invoke(listSplit$default.get(0), listSplit$default.get(1)));
        }
        return h0.toMap(arrayList, map);
    }

    public static /* synthetic */ Map getStringEntrySetAsMap$default(SharedPreferences sharedPreferences, String str, String str2, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = ",";
        }
        return getStringEntrySetAsMap(sharedPreferences, str, str2, function2);
    }

    public static final String getStringNonNull(SharedPreferences sharedPreferences, String str, String str2) {
        m.checkNotNullParameter(sharedPreferences, "$this$getStringNonNull");
        m.checkNotNullParameter(str, "key");
        m.checkNotNullParameter(str2, "defValue");
        String string = sharedPreferences.getString(str, str2);
        return string != null ? string : str2;
    }

    public static final Set<String> getStringSetNonNull(SharedPreferences sharedPreferences, String str, Set<String> set) {
        m.checkNotNullParameter(sharedPreferences, "$this$getStringSetNonNull");
        m.checkNotNullParameter(str, "key");
        m.checkNotNullParameter(set, "defValues");
        Set<String> stringSet = sharedPreferences.getStringSet(str, set);
        return stringSet != null ? stringSet : n0.emptySet();
    }

    public static /* synthetic */ Set getStringSetNonNull$default(SharedPreferences sharedPreferences, String str, Set set, int i, Object obj) {
        if ((i & 2) != 0) {
            set = n0.emptySet();
        }
        return getStringSetNonNull(sharedPreferences, str, set);
    }

    public static final <K, V> void putStringEntrySetAsMap(SharedPreferences.Editor editor, String str, Map<K, ? extends V> map, String str2, Function1<? super V, String> function1) {
        m.checkNotNullParameter(editor, "$this$putStringEntrySetAsMap");
        m.checkNotNullParameter(str, "cacheKey");
        m.checkNotNullParameter(map, "value");
        m.checkNotNullParameter(str2, "delimiter");
        m.checkNotNullParameter(function1, "transformer");
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<K, ? extends V> entry : map.entrySet()) {
            arrayList.add(entry.getKey() + str2 + function1.invoke(entry.getValue()));
        }
        editor.putStringSet(str, u.toSet(arrayList));
    }

    public static /* synthetic */ void putStringEntrySetAsMap$default(SharedPreferences.Editor editor, String str, Map map, String str2, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = ",";
        }
        if ((i & 8) != 0) {
            function1 = AnonymousClass1.INSTANCE;
        }
        putStringEntrySetAsMap(editor, str, map, str2, function1);
    }
}
