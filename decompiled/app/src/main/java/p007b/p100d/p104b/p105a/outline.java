package p007b.p100d.p104b.p105a;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import com.discord.api.channel.Channel;
import com.discord.models.domain.Model;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.esotericsoftware.kryo.KryoException;
import com.google.android.exoplayer2.ParserException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Tuples2;
import kotlin.jvm.internal.Ref$ObjectRef;
import p007b.p008a.p009a.p011a0.WidgetGiftAcceptDialog;
import p007b.p008a.p025i.WidgetAcceptGiftDialogBinding;
import p007b.p008a.p041q.p047o0.VideoQuality;
import p007b.p225i.p361c.p369m.p370d.Logger3;
import p507d0.Tuples;
import p507d0.p513e0.KProperty3;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.Flags2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11980i;
import p507d0.p592z.p594d.InlineMarker;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.PropertyReference1Impl;
import p507d0.p592z.p594d.Reflection2;
import p617h0.p618a.p619a.ByteVector2;
import p617h0.p618a.p619a.SymbolTable2;

/* compiled from: outline */
/* renamed from: b.d.b.a.a, reason: use source file name */
/* loaded from: classes.dex */
public class outline {
    /* renamed from: A */
    public static String m813A(StringBuilder sb, int i, char c) {
        sb.append(i);
        sb.append(c);
        return sb.toString();
    }

    /* renamed from: B */
    public static String m814B(StringBuilder sb, int i, String str) {
        sb.append(i);
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: C */
    public static String m815C(StringBuilder sb, long j, String str) {
        sb.append(j);
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: D */
    public static String m816D(StringBuilder sb, Boolean bool, String str) {
        sb.append(bool);
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: E */
    public static String m817E(StringBuilder sb, CharSequence charSequence, String str) {
        sb.append(charSequence);
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: F */
    public static String m818F(StringBuilder sb, Integer num, String str) {
        sb.append(num);
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: G */
    public static String m819G(StringBuilder sb, Long l, String str) {
        sb.append(l);
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: H */
    public static String m820H(StringBuilder sb, String str, char c) {
        sb.append(str);
        sb.append(c);
        return sb.toString();
    }

    /* renamed from: I */
    public static Context m821I(TextView textView, String str, String str2) {
        Intrinsics3.checkNotNullExpressionValue(textView, str);
        Context context = textView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, str2);
        return context;
    }

    /* renamed from: J */
    public static String m822J(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    /* renamed from: K */
    public static String m823K(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    /* renamed from: L */
    public static String m824L(StringBuilder sb, List list, String str) {
        sb.append(list);
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: M */
    public static String m825M(StringBuilder sb, Map map, String str) {
        sb.append(map);
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: N */
    public static String m826N(StringBuilder sb, Set set, String str) {
        sb.append(set);
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: O */
    public static String m827O(StringBuilder sb, boolean z2, String str) {
        sb.append(z2);
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: P */
    public static String m828P(Object[] objArr, int i, String str, String str2) {
        String str3 = String.format(str, Arrays.copyOf(objArr, i));
        Intrinsics3.checkNotNullExpressionValue(str3, str2);
        return str3;
    }

    /* renamed from: Q */
    public static StringBuilder m829Q(char c) {
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        return sb;
    }

    /* renamed from: R */
    public static StringBuilder m830R(int i, String str, long j, String str2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(j);
        sb.append(str2);
        return sb;
    }

    /* renamed from: S */
    public static StringBuilder m831S(int i, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        return sb;
    }

    /* renamed from: T */
    public static Bundle m832T(String str, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong(str, j);
        return bundle;
    }

    /* renamed from: U */
    public static StringBuilder m833U(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    /* renamed from: V */
    public static StringBuilder m834V(String str, int i, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i);
        sb.append(str2);
        return sb;
    }

    /* renamed from: W */
    public static StringBuilder m835W(String str, int i, String str2, int i2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i);
        sb.append(str2);
        sb.append(i2);
        sb.append(str3);
        return sb;
    }

    /* renamed from: X */
    public static StringBuilder m836X(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }

    /* renamed from: Y */
    public static StringBuilder m837Y(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    /* renamed from: Z */
    public static StringBuilder m838Z(String str, InterfaceC11980i interfaceC11980i, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(interfaceC11980i);
        sb.append(str2);
        return sb;
    }

    /* renamed from: a */
    public static float m839a(float f, float f2, float f3, float f4) {
        return ((f - f2) * f3) + f4;
    }

    /* renamed from: a0 */
    public static ArrayList m840a0(List list, String str) {
        Intrinsics3.checkNotNullExpressionValue(list, str);
        return new ArrayList();
    }

    /* renamed from: b */
    public static int m841b(String str, int i) {
        return String.valueOf(str).length() + i;
    }

    /* renamed from: b0 */
    public static Tuples2 m842b0(VideoQuality.b bVar, Float f, String str) {
        return Tuples.m10073to(str, Long.valueOf(VideoQuality.b.m359a(bVar, f)));
    }

    /* renamed from: c */
    public static Object m843c(Channel channel, Map map) {
        return map.get(Long.valueOf(channel.getGuildId()));
    }

    /* renamed from: c0 */
    public static Ref$ObjectRef m844c0(Model.JsonReader jsonReader, String str) {
        Intrinsics3.checkNotNullParameter(jsonReader, str);
        return new Ref$ObjectRef();
    }

    /* renamed from: d */
    public static Object m845d(Channel channel, Map map) {
        return map.get(Long.valueOf(channel.getId()));
    }

    /* renamed from: d0 */
    public static KProperty3 m846d0(Class cls, String str, String str2, int i) {
        return Reflection2.property1(new PropertyReference1Impl(cls, str, str2, i));
    }

    /* renamed from: e */
    public static Object m847e(Guild guild, Map map) {
        return map.get(Long.valueOf(guild.getId()));
    }

    /* renamed from: e0 */
    public static ViewModelProvider.Factory m848e0(Fragment fragment, String str) {
        FragmentActivity fragmentActivityRequireActivity = fragment.requireActivity();
        Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, str);
        return fragmentActivityRequireActivity.getDefaultViewModelProviderFactory();
    }

    /* renamed from: f */
    public static Object m849f(User user, Map map) {
        return map.get(Long.valueOf(user.getId()));
    }

    /* renamed from: f0 */
    public static void m850f0(int i, Canvas canvas, int i2, int i3) {
        InlineMarker.finallyStart(i);
        canvas.restoreToCount(i2);
        InlineMarker.finallyEnd(i3);
    }

    /* renamed from: g */
    public static String m851g(int i, String str, int i2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        return sb.toString();
    }

    /* renamed from: g0 */
    public static void m852g0(int i, String str, int i2, String str2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        Log.w(str2, sb.toString());
    }

    /* renamed from: h */
    public static String m853h(int i, String str, int i2, String str2, int i3) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        sb.append(str2);
        sb.append(i3);
        return sb.toString();
    }

    /* renamed from: h0 */
    public static void m854h0(int i, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        Log.w(str3, sb.toString());
    }

    /* renamed from: i */
    public static String m855i(int i, String str, long j, String str2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(j);
        sb.append(str2);
        return sb.toString();
    }

    /* renamed from: i0 */
    public static void m856i0(int i, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        Log.w(str4, sb.toString());
    }

    /* renamed from: j */
    public static String m857j(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    /* renamed from: j0 */
    public static void m858j0(int i, HashMap map, String str, int i2, String str2, int i3, String str3, int i4, String str4) {
        map.put(str, Integer.valueOf(i));
        map.put(str2, Integer.valueOf(i2));
        map.put(str3, Integer.valueOf(i3));
        map.put(str4, Integer.valueOf(i4));
    }

    /* renamed from: k */
    public static String m859k(int i, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    /* renamed from: k0 */
    public static void m860k0(Class cls, StringBuilder sb, String str) {
        sb.append(cls.getName());
        sb.append(str);
    }

    /* renamed from: l */
    public static String m861l(int i, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        return sb.toString();
    }

    /* renamed from: l0 */
    public static void m862l0(Class cls, StringBuilder sb, String str) {
        sb.append(Reflection2.getOrCreateKotlinClass(cls).getSimpleName());
        sb.append(str);
    }

    /* renamed from: m */
    public static int m863m(String str, int i, int i2) {
        return (str.hashCode() + i) * i2;
    }

    /* renamed from: m0 */
    public static void m864m0(Class cls, StringBuilder sb, String str, KryoException kryoException) {
        sb.append(cls.getName());
        sb.append(str);
        kryoException.addTrace(sb.toString());
    }

    /* renamed from: n */
    public static String m865n(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.exceptionLabel());
        return sb.toString();
    }

    /* renamed from: n0 */
    public static void m866n0(String str, int i, String str2) {
        Log.d(str2, str + i);
    }

    /* renamed from: o */
    public static String m867o(Class cls, StringBuilder sb, String str) {
        sb.append(cls.getName());
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: o0 */
    public static void m868o0(String str, String str2, Logger3 logger3) {
        logger3.m6371b(str + str2);
    }

    /* renamed from: p */
    public static String m869p(Class cls, StringBuilder sb, String str, String str2) {
        sb.append(cls.getSimpleName());
        sb.append(str);
        sb.append(cls.getSimpleName());
        sb.append(str2);
        return sb.toString();
    }

    /* renamed from: p0 */
    public static ViewModelStore m870p0(Fragment fragment, String str, String str2) {
        FragmentActivity fragmentActivityRequireActivity = fragment.requireActivity();
        Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, str);
        ViewModelStore viewModelStore = fragmentActivityRequireActivity.getViewModelStore();
        Intrinsics3.checkNotNullExpressionValue(viewModelStore, str2);
        return viewModelStore;
    }

    /* renamed from: q */
    public static String m871q(String str, int i) {
        return str + i;
    }

    /* renamed from: q0 */
    public static void m872q0(String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics3.checkNotNullParameter(str, str2);
        Intrinsics3.checkNotNullParameter(str3, str4);
        Intrinsics3.checkNotNullParameter(str5, str6);
    }

    /* renamed from: r */
    public static String m873r(String str, int i, String str2) {
        return str + i + str2;
    }

    /* renamed from: r0 */
    public static void m874r0(StringBuilder sb, String str, String str2) {
        sb.append(str);
        Log.w(str2, sb.toString());
    }

    /* renamed from: s */
    public static String m875s(String str, int i, String str2, int i2) {
        return str + i + str2 + i2;
    }

    /* renamed from: s0 */
    public static void m876s0(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
    }

    /* renamed from: t */
    public static String m877t(String str, long j) {
        return str + j;
    }

    /* renamed from: t0 */
    public static void m878t0(SymbolTable2 symbolTable2, String str, ByteVector2 byteVector2, int i) {
        byteVector2.m10538j(symbolTable2.m10637l(str));
        byteVector2.m10537i(i);
    }

    /* renamed from: u */
    public static String m879u(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    /* renamed from: u0 */
    public static boolean m880u0(Flags2.b bVar, int i, String str) {
        Boolean bool = bVar.get(i);
        Intrinsics3.checkNotNullExpressionValue(bool, str);
        return bool.booleanValue();
    }

    /* renamed from: v */
    public static String m881v(String str, Object obj) {
        return str + obj;
    }

    /* renamed from: v0 */
    public static WidgetAcceptGiftDialogBinding m882v0(TextView textView, String str, CharSequence charSequence, WidgetGiftAcceptDialog widgetGiftAcceptDialog) {
        Intrinsics3.checkNotNullExpressionValue(textView, str);
        textView.setText(charSequence);
        return widgetGiftAcceptDialog.m105h();
    }

    /* renamed from: w */
    public static String m883w(String str, String str2) {
        return str + str2;
    }

    /* renamed from: w0 */
    public static ParserException m884w0(int i, String str, int i2, Throwable th) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        return ParserException.m8755a(sb.toString(), th);
    }

    /* renamed from: x */
    public static Context m885x(View view, String str, String str2) {
        Intrinsics3.checkNotNullExpressionValue(view, str);
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, str2);
        return context;
    }

    /* renamed from: y */
    public static String m886y(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    /* renamed from: z */
    public static String m887z(String str, Type type) {
        return str + type;
    }
}
