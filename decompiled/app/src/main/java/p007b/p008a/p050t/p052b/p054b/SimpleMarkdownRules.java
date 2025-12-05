package p007b.p008a.p050t.p052b.p054b;

import android.text.style.CharacterStyle;
import android.text.style.StyleSpan;
import java.util.List;
import kotlin.jvm.functions.Function0;
import p507d0.p580t.CollectionsJVM;
import p507d0.p592z.p594d.Lambda;

/* compiled from: SimpleMarkdownRules.kt */
/* renamed from: b.a.t.b.b.a, reason: use source file name */
/* loaded from: classes.dex */
public final class SimpleMarkdownRules extends Lambda implements Function0<List<? extends CharacterStyle>> {

    /* renamed from: j */
    public static final SimpleMarkdownRules f1980j = new SimpleMarkdownRules();

    public SimpleMarkdownRules() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public List<? extends CharacterStyle> invoke() {
        return CollectionsJVM.listOf(new StyleSpan(1));
    }
}
