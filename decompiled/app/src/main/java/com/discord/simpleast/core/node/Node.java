package com.discord.simpleast.core.node;

import android.text.SpannableStringBuilder;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Node.kt */
/* loaded from: classes.dex */
public class Node<R> {
    private Collection<Node<R>> children;

    /* compiled from: Node.kt */
    public static class a<R> extends Node<R> {

        /* compiled from: Node.kt */
        /* renamed from: com.discord.simpleast.core.node.Node$a$a, reason: collision with other inner class name */
        public static final class C0189a extends o implements Function1<Node<R>, CharSequence> {
            public static final C0189a j = new C0189a();

            public C0189a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public CharSequence invoke(Object obj) {
                Node node = (Node) obj;
                m.checkNotNullParameter(node, "it");
                return node.toString();
            }
        }

        public a(Node<R>... nodeArr) {
            m.checkNotNullParameter(nodeArr, "children");
            ArrayList arrayList = new ArrayList();
            for (Node<R> node : nodeArr) {
                if (node != null) {
                    arrayList.add(node);
                }
            }
            super(u.toMutableList((Collection) arrayList));
        }

        @Override // com.discord.simpleast.core.node.Node
        public void render(SpannableStringBuilder spannableStringBuilder, R r) {
            m.checkNotNullParameter(spannableStringBuilder, "builder");
            Collection<Node<R>> children = getChildren();
            if (children != null) {
                Iterator<T> it = children.iterator();
                while (it.hasNext()) {
                    ((Node) it.next()).render(spannableStringBuilder, r);
                }
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getSimpleName());
            sb.append(" >\n");
            Collection<Node<R>> children = getChildren();
            sb.append(children != null ? u.joinToString$default(children, "\n->", ">>", "\n>|", 0, null, C0189a.j, 24, null) : null);
            return sb.toString();
        }
    }

    public Node() {
        this(null, 1, null);
    }

    public Node(Collection<Node<R>> collection) {
        this.children = collection;
    }

    public final void addChild(Node<R> child) {
        m.checkNotNullParameter(child, "child");
        Collection<Node<R>> arrayList = this.children;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(child);
        this.children = arrayList;
    }

    public final Collection<Node<R>> getChildren() {
        return this.children;
    }

    public final boolean hasChildren() {
        Collection<Node<R>> collection = this.children;
        return collection != null && (collection.isEmpty() ^ true);
    }

    public void render(SpannableStringBuilder builder, R renderContext) {
        m.checkNotNullParameter(builder, "builder");
    }

    public /* synthetic */ Node(Collection collection, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : collection);
    }
}
