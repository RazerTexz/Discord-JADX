package p007b.p008a.p050t.p052b.p054b;

import android.text.style.CharacterStyle;
import android.text.style.StrikethroughSpan;
import java.util.List;
import kotlin.jvm.functions.Function0;
import p507d0.p580t.CollectionsJVM;
import p507d0.p592z.p594d.Lambda;

/* compiled from: SimpleMarkdownRules.kt */
/* renamed from: b.a.t.b.b.f, reason: use source file name */
/* loaded from: classes.dex */
public final class SimpleMarkdownRules6 extends Lambda implements Function0<List<? extends CharacterStyle>> {

    /* renamed from: j */
    public static final SimpleMarkdownRules6 f1990j = new SimpleMarkdownRules6();

    public SimpleMarkdownRules6() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public List<? extends CharacterStyle> invoke() {
        return CollectionsJVM.listOf(new StrikethroughSpan());
    }
}
