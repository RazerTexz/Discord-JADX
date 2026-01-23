package p007b.p008a.p050t.p052b.p053a;

import android.text.SpannableStringBuilder;
import com.discord.simpleast.core.node.Node;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.a.t.b.a.a, reason: use source file name */
/* JADX INFO: compiled from: TextNode.kt */
/* JADX INFO: loaded from: classes.dex */
public class TextNode<R> extends Node<R> {
    private final String content;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextNode(String str) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(str, "content");
        this.content = str;
    }

    public final String getContent() {
        return this.content;
    }

    @Override // com.discord.simpleast.core.node.Node
    public void render(SpannableStringBuilder spannableStringBuilder, R r) {
        Intrinsics3.checkNotNullParameter(spannableStringBuilder, "builder");
        spannableStringBuilder.append((CharSequence) this.content);
    }

    public String toString() {
        return getClass().getSimpleName() + ": " + this.content;
    }
}
