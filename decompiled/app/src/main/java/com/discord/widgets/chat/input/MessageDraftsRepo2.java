package com.discord.widgets.chat.input;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.MessageDraftsRepo$Provider$MESSAGE_DRAFTS_REPO_INSTANCE$2, reason: use source file name */
/* JADX INFO: compiled from: MessageDraftsRepo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageDraftsRepo2 extends Lambda implements Function0<MessageDraftsRepo> {
    public static final MessageDraftsRepo2 INSTANCE = new MessageDraftsRepo2();

    public MessageDraftsRepo2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ MessageDraftsRepo invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final MessageDraftsRepo invoke() {
        return new MessageDraftsRepo(null);
    }
}
