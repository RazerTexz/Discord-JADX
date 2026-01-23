package p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b;

import androidx.exifinterface.media.ExifInterface;
import com.discord.widgets.chat.input.MentionUtils;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.Collections2;
import p507d0.p580t._Collections;
import p507d0.p588x.progressionUtil;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.b.b, reason: use source file name */
/* JADX INFO: compiled from: ClassMapperLite.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ClassMapperLite {

    /* JADX INFO: renamed from: a */
    public static final ClassMapperLite f23700a = new ClassMapperLite();

    /* JADX INFO: renamed from: b */
    public static final String f23701b = _Collections.joinToString$default(Collections2.listOf((Object[]) new Character[]{'k', 'o', 't', 'l', 'i', 'n'}), "", null, null, 0, null, null, 62, null);

    /* JADX INFO: renamed from: c */
    public static final Map<String, String> f23702c;

    static {
        int i = 0;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List listListOf = Collections2.listOf((Object[]) new String[]{"Boolean", "Z", "Char", "C", "Byte", "B", "Short", ExifInterface.LATITUDE_SOUTH, "Int", "I", "Float", "F", "Long", "J", "Double", "D"});
        int progressionLastElement = progressionUtil.getProgressionLastElement(0, listListOf.size() - 1, 2);
        if (progressionLastElement >= 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 2;
                StringBuilder sb = new StringBuilder();
                String str = f23701b;
                sb.append(str);
                sb.append(MentionUtils.SLASH_CHAR);
                sb.append((String) listListOf.get(i2));
                int i4 = i2 + 1;
                linkedHashMap.put(sb.toString(), listListOf.get(i4));
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(MentionUtils.SLASH_CHAR);
                linkedHashMap.put(outline.m822J(sb2, (String) listListOf.get(i2), "Array"), Intrinsics3.stringPlus("[", listListOf.get(i4)));
                if (i2 == progressionLastElement) {
                    break;
                } else {
                    i2 = i3;
                }
            }
        }
        linkedHashMap.put(Intrinsics3.stringPlus(f23701b, "/Unit"), ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        m9585a(linkedHashMap, "Any", "java/lang/Object");
        m9585a(linkedHashMap, "Nothing", "java/lang/Void");
        m9585a(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        for (String str2 : Collections2.listOf((Object[]) new String[]{"String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum"})) {
            m9585a(linkedHashMap, str2, Intrinsics3.stringPlus("java/lang/", str2));
        }
        for (String str3 : Collections2.listOf((Object[]) new String[]{"Iterator", "Collection", "List", "Set", "Map", "ListIterator"})) {
            m9585a(linkedHashMap, Intrinsics3.stringPlus("collections/", str3), Intrinsics3.stringPlus("java/util/", str3));
            m9585a(linkedHashMap, Intrinsics3.stringPlus("collections/Mutable", str3), Intrinsics3.stringPlus("java/util/", str3));
        }
        m9585a(linkedHashMap, "collections/Iterable", "java/lang/Iterable");
        m9585a(linkedHashMap, "collections/MutableIterable", "java/lang/Iterable");
        m9585a(linkedHashMap, "collections/Map.Entry", "java/util/Map$Entry");
        m9585a(linkedHashMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        while (true) {
            int i5 = i + 1;
            String strStringPlus = Intrinsics3.stringPlus("Function", Integer.valueOf(i));
            StringBuilder sb3 = new StringBuilder();
            String str4 = f23701b;
            sb3.append(str4);
            sb3.append("/jvm/functions/Function");
            sb3.append(i);
            m9585a(linkedHashMap, strStringPlus, sb3.toString());
            m9585a(linkedHashMap, Intrinsics3.stringPlus("reflect/KFunction", Integer.valueOf(i)), Intrinsics3.stringPlus(str4, "/reflect/KFunction"));
            if (i5 > 22) {
                break;
            } else {
                i = i5;
            }
        }
        for (String str5 : Collections2.listOf((Object[]) new String[]{"Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum"})) {
            m9585a(linkedHashMap, Intrinsics3.stringPlus(str5, ".Companion"), f23701b + "/jvm/internal/" + str5 + "CompanionObject");
        }
        f23702c = linkedHashMap;
    }

    /* JADX INFO: renamed from: a */
    public static final void m9585a(Map<String, String> map, String str, String str2) {
        map.put(f23701b + MentionUtils.SLASH_CHAR + str, 'L' + str2 + ';');
    }

    public static final String mapClass(String str) {
        Intrinsics3.checkNotNullParameter(str, "classId");
        String str2 = f23702c.get(str);
        return str2 == null ? outline.m820H(outline.m829Q('L'), StringsJVM.replace$default(str, '.', '$', false, 4, (Object) null), ';') : str2;
    }
}
