package com.discord.utilities.textprocessing;

import b.a.t.b.c.a;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.textprocessing.node.Spoilerable;

/* compiled from: MessagePreprocessor.kt */
/* loaded from: classes2.dex */
public final class MessagePreprocessor$processSpoilerChildren$3$1 implements a {
    public static final MessagePreprocessor$processSpoilerChildren$3$1 INSTANCE = new MessagePreprocessor$processSpoilerChildren$3$1();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.a.t.b.c.a
    public final void processNode(Node<Object> node) {
        if (node instanceof Spoilerable) {
            ((Spoilerable) node).setRevealed(false);
        }
    }
}
