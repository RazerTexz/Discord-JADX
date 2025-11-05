package com.discord.simpleast.code;

import android.text.SpannableStringBuilder;
import b.a.t.a.f;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import d0.z.d.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CodeNode.kt */
/* loaded from: classes.dex */
public class CodeNode<RC> extends b.a.t.b.a.a<RC> {

    /* renamed from: a, reason: from kotlin metadata */
    public final String language;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final StyleNode.a<RC> stylesProvider;

    /* compiled from: CodeNode.kt */
    public static abstract class a {
        public final String a;

        /* compiled from: CodeNode.kt */
        /* renamed from: com.discord.simpleast.code.CodeNode$a$a, reason: collision with other inner class name */
        public static final class C0188a<RC> extends a {

            /* renamed from: b, reason: collision with root package name */
            public final List<Node<RC>> f2807b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0188a(String str, List<? extends Node<RC>> list) {
                super(str, null);
                m.checkNotNullParameter(str, "raw");
                m.checkNotNullParameter(list, "children");
                this.f2807b = list;
            }
        }

        /* compiled from: CodeNode.kt */
        public static final class b extends a {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(str, null);
                m.checkNotNullParameter(str, "body");
            }
        }

        public a(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this.a = str;
        }
    }

    /* compiled from: CodeNode.kt */
    public static final class b<RC> extends Node.a<RC> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, f<RC> fVar) {
            super(new StyleNode.b(str, fVar.d), new StyleNode.b(str2, fVar.f));
            m.checkNotNullParameter(str, "pre");
            m.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
            m.checkNotNullParameter(fVar, "codeStyleProviders");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CodeNode(a aVar, String str, StyleNode.a<RC> aVar2) {
        super(aVar.a);
        m.checkNotNullParameter(aVar, "content");
        m.checkNotNullParameter(aVar2, "stylesProvider");
        this.language = str;
        this.stylesProvider = aVar2;
        if (aVar instanceof a.C0188a) {
            Iterator<T> it = ((a.C0188a) aVar).f2807b.iterator();
            while (it.hasNext()) {
                Node<R> node = (Node) it.next();
                Objects.requireNonNull(node, "null cannot be cast to non-null type com.discord.simpleast.core.node.Node<RC>");
                addChild(node);
            }
        }
    }

    public boolean equals(Object other) {
        if (other instanceof CodeNode) {
            CodeNode codeNode = (CodeNode) other;
            if (m.areEqual(codeNode.language, this.language) && m.areEqual(codeNode.getContent(), getContent())) {
                return true;
            }
        }
        return false;
    }

    @Override // b.a.t.b.a.a, com.discord.simpleast.core.node.Node
    public void render(SpannableStringBuilder builder, RC renderContext) {
        m.checkNotNullParameter(builder, "builder");
        Iterable<?> iterable = this.stylesProvider.get(renderContext);
        if (!hasChildren()) {
            int length = builder.length();
            builder.append(getContent());
            Iterator<?> it = iterable.iterator();
            while (it.hasNext()) {
                builder.setSpan(it.next(), length, builder.length(), 17);
            }
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<?> it2 = iterable.iterator();
        while (it2.hasNext()) {
            spannableStringBuilder.setSpan(it2.next(), 0, 0, 18);
        }
        Collection<Node<RC>> children = getChildren();
        if (children != null) {
            Iterator<T> it3 = children.iterator();
            while (it3.hasNext()) {
                ((Node) it3.next()).render(spannableStringBuilder, renderContext);
            }
        }
        builder.append((char) 8202);
        builder.insert(builder.length() - 1, (CharSequence) spannableStringBuilder);
    }
}
