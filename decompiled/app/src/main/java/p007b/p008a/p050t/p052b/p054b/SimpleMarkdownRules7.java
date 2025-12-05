package p007b.p008a.p050t.p052b.p054b;

import android.text.style.CharacterStyle;
import android.text.style.UnderlineSpan;
import java.util.List;
import kotlin.jvm.functions.Function0;
import p507d0.p580t.CollectionsJVM;
import p507d0.p592z.p594d.Lambda;

/* compiled from: SimpleMarkdownRules.kt */
/* renamed from: b.a.t.b.b.g, reason: use source file name */
/* loaded from: classes.dex */
public final class SimpleMarkdownRules7 extends Lambda implements Function0<List<? extends CharacterStyle>> {

    /* renamed from: j */
    public static final SimpleMarkdownRules7 f1991j = new SimpleMarkdownRules7();

    public SimpleMarkdownRules7() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public List<? extends CharacterStyle> invoke() {
        return CollectionsJVM.listOf(new UnderlineSpan());
    }
}
