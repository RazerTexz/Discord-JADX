package com.discord.simpleast.core.node;

import android.text.SpannableStringBuilder;
import androidx.exifinterface.media.ExifInterface;
import com.discord.simpleast.core.node.Node;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StyleNode.kt */
/* loaded from: classes.dex */
public class StyleNode<RC, T> extends Node.a<RC> {

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
    public interface a<RC> {
        Iterable<?> get(RC rc);
    }

    /* compiled from: StyleNode.kt */
    public static final class b<RC> extends b.a.t.b.a.a<RC> {
        public final a<RC> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, a<RC> aVar) {
            super(str);
            m.checkNotNullParameter(str, "content");
            m.checkNotNullParameter(aVar, "stylesProvider");
            this.a = aVar;
        }

        @Override // b.a.t.b.a.a, com.discord.simpleast.core.node.Node
        public void render(SpannableStringBuilder spannableStringBuilder, RC rc) {
            m.checkNotNullParameter(spannableStringBuilder, "builder");
            int length = spannableStringBuilder.length();
            super.render(spannableStringBuilder, rc);
            Iterator<?> it = this.a.get(rc).iterator();
            while (it.hasNext()) {
                spannableStringBuilder.setSpan(it.next(), length, spannableStringBuilder.length(), 33);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StyleNode(List<? extends T> list) {
        super(new Node[0]);
        m.checkNotNullParameter(list, "styles");
        this.styles = list;
    }

    public static final <RC, T> StyleNode<RC, T> wrapText(String str, List<? extends T> list) {
        Objects.requireNonNull(INSTANCE);
        m.checkNotNullParameter(str, "content");
        m.checkNotNullParameter(list, "styles");
        StyleNode<RC, T> styleNode = new StyleNode<>(list);
        styleNode.addChild(new b.a.t.b.a.a(str));
        return styleNode;
    }

    public final List<T> getStyles() {
        return this.styles;
    }

    @Override // com.discord.simpleast.core.node.Node.a, com.discord.simpleast.core.node.Node
    public void render(SpannableStringBuilder builder, RC renderContext) {
        m.checkNotNullParameter(builder, "builder");
        int length = builder.length();
        super.render(builder, renderContext);
        Iterator<T> it = this.styles.iterator();
        while (it.hasNext()) {
            builder.setSpan(it.next(), length, builder.length(), 33);
        }
    }
}
