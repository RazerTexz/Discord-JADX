package com.discord.simpleast.core.parser;

import androidx.exifinterface.media.ExifInterface;
import com.discord.simpleast.core.node.Node;
import d0.z.d.m;

/* compiled from: ParseSpec.kt */
/* loaded from: classes.dex */
public final class ParseSpec<R, S> {

    /* renamed from: a, reason: from kotlin metadata */
    public final Node<R> root;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final boolean isTerminal;

    /* renamed from: c, reason: from kotlin metadata */
    public final S state;

    /* renamed from: d, reason: from kotlin metadata */
    public int startIndex;

    /* renamed from: e, reason: from kotlin metadata */
    public int endIndex;

    public ParseSpec(Node<R> node, S s2, int i, int i2) {
        m.checkNotNullParameter(node, "root");
        this.root = node;
        this.state = s2;
        this.isTerminal = false;
        this.startIndex = i;
        this.endIndex = i2;
    }

    public ParseSpec(Node<R> node, S s2) {
        m.checkNotNullParameter(node, "root");
        this.root = node;
        this.state = s2;
        this.isTerminal = true;
    }
}
