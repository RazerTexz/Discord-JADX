package com.discord.simpleast.core.node;

import android.text.SpannableStringBuilder;
import androidx.exifinterface.media.ExifInterface;
import com.discord.simpleast.core.node.Node;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p050t.p052b.p053a.TextNode;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: StyleNode.kt */
/* loaded from: classes.dex */
public class StyleNode<RC, T> extends Node.C5655a<RC> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<T> styles;

    /* compiled from: StyleNode.kt */
    public static final class Companion {
        public Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: StyleNode.kt */
    /* renamed from: com.discord.simpleast.core.node.StyleNode$a */
    public interface InterfaceC5656a<RC> {
        Iterable<?> get(RC rc);
    }

    /* compiled from: StyleNode.kt */
    /* renamed from: com.discord.simpleast.core.node.StyleNode$b */
    public static final class C5657b<RC> extends TextNode<RC> {

        /* renamed from: a */
        public final InterfaceC5656a<RC> f18952a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C5657b(String str, InterfaceC5656a<RC> interfaceC5656a) {
            super(str);
            Intrinsics3.checkNotNullParameter(str, "content");
            Intrinsics3.checkNotNullParameter(interfaceC5656a, "stylesProvider");
            this.f18952a = interfaceC5656a;
        }

        @Override // p007b.p008a.p050t.p052b.p053a.TextNode, com.discord.simpleast.core.node.Node
        public void render(SpannableStringBuilder spannableStringBuilder, RC rc) {
            Intrinsics3.checkNotNullParameter(spannableStringBuilder, "builder");
            int length = spannableStringBuilder.length();
            super.render(spannableStringBuilder, rc);
            Iterator<?> it = this.f18952a.get(rc).iterator();
            while (it.hasNext()) {
                spannableStringBuilder.setSpan(it.next(), length, spannableStringBuilder.length(), 33);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StyleNode(List<? extends T> list) {
        super(new Node[0]);
        Intrinsics3.checkNotNullParameter(list, "styles");
        this.styles = list;
    }

    public static final <RC, T> StyleNode<RC, T> wrapText(String str, List<? extends T> list) {
        Objects.requireNonNull(INSTANCE);
        Intrinsics3.checkNotNullParameter(str, "content");
        Intrinsics3.checkNotNullParameter(list, "styles");
        StyleNode<RC, T> styleNode = new StyleNode<>(list);
        styleNode.addChild(new TextNode(str));
        return styleNode;
    }

    public final List<T> getStyles() {
        return this.styles;
    }

    @Override // com.discord.simpleast.core.node.Node.C5655a, com.discord.simpleast.core.node.Node
    public void render(SpannableStringBuilder builder, RC renderContext) {
        Intrinsics3.checkNotNullParameter(builder, "builder");
        int length = builder.length();
        super.render(builder, renderContext);
        Iterator<T> it = this.styles.iterator();
        while (it.hasNext()) {
            builder.setSpan(it.next(), length, builder.length(), 33);
        }
    }
}
