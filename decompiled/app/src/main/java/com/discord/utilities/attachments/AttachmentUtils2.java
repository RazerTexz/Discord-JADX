package com.discord.utilities.attachments;

import d0.z.d.Lambda;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function0;

/* compiled from: AttachmentUtils.kt */
/* renamed from: com.discord.utilities.attachments.AttachmentUtilsKt$REGEX_FILE_NAME_PATTERN$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class AttachmentUtils2 extends Lambda implements Function0<Pattern> {
    public static final AttachmentUtils2 INSTANCE = new AttachmentUtils2();

    public AttachmentUtils2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Pattern invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Pattern invoke2() {
        return Pattern.compile("(.*)\\.(\\w+)$");
    }
}
