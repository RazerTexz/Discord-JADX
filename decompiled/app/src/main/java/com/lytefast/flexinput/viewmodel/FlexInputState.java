package com.lytefast.flexinput.viewmodel;

import com.lytefast.flexinput.model.Attachment;
import java.util.List;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: FlexInputState.kt */
/* loaded from: classes3.dex */
public final /* data */ class FlexInputState {

    /* renamed from: a, reason: from kotlin metadata */
    public final String inputText;

    /* renamed from: b, reason: from kotlin metadata */
    public final boolean showExpandedButtons;

    /* renamed from: c, reason: from kotlin metadata */
    public final List<Attachment<Object>> attachments;

    /* renamed from: d, reason: from kotlin metadata */
    public final boolean attachmentViewEnabled;

    /* renamed from: e, reason: from kotlin metadata */
    public final boolean singleSelectMode;

    /* renamed from: f, reason: from kotlin metadata */
    public final Integer showContentDialogIndex;

    /* renamed from: g, reason: from kotlin metadata */
    public final boolean ableToSendMessages;

    /* renamed from: h, reason: from kotlin metadata */
    public final boolean ableToAttachFiles;

    /* renamed from: i, reason: from kotlin metadata */
    public final boolean showExpressionTray;

    /* renamed from: j, reason: from kotlin metadata */
    public final boolean showExpressionTrayButtonBadge;

    /* renamed from: k, reason: from kotlin metadata */
    public final boolean expressionSuggestionsEnabled;

    /* renamed from: l, reason: from kotlin metadata */
    public final Long channelId;

    /* renamed from: m, reason: from kotlin metadata */
    public final Long guildId;

    public FlexInputState() {
        this(null, false, null, false, false, null, false, false, false, false, false, null, null, 8191);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FlexInputState(String str, boolean z2, List<? extends Attachment<? extends Object>> list, boolean z3, boolean z4, Integer num, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, Long l, Long l2) {
        Intrinsics3.checkNotNullParameter(str, "inputText");
        Intrinsics3.checkNotNullParameter(list, "attachments");
        this.inputText = str;
        this.showExpandedButtons = z2;
        this.attachments = list;
        this.attachmentViewEnabled = z3;
        this.singleSelectMode = z4;
        this.showContentDialogIndex = num;
        this.ableToSendMessages = z5;
        this.ableToAttachFiles = z6;
        this.showExpressionTray = z7;
        this.showExpressionTrayButtonBadge = z8;
        this.expressionSuggestionsEnabled = z9;
        this.channelId = l;
        this.guildId = l2;
    }

    /* renamed from: a */
    public static FlexInputState m9302a(FlexInputState flexInputState, String str, boolean z2, List list, boolean z3, boolean z4, Integer num, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, Long l, Long l2, int i) {
        String str2 = (i & 1) != 0 ? flexInputState.inputText : str;
        boolean z10 = (i & 2) != 0 ? flexInputState.showExpandedButtons : z2;
        List list2 = (i & 4) != 0 ? flexInputState.attachments : list;
        boolean z11 = (i & 8) != 0 ? flexInputState.attachmentViewEnabled : z3;
        boolean z12 = (i & 16) != 0 ? flexInputState.singleSelectMode : z4;
        Integer num2 = (i & 32) != 0 ? flexInputState.showContentDialogIndex : num;
        boolean z13 = (i & 64) != 0 ? flexInputState.ableToSendMessages : z5;
        boolean z14 = (i & 128) != 0 ? flexInputState.ableToAttachFiles : z6;
        boolean z15 = (i & 256) != 0 ? flexInputState.showExpressionTray : z7;
        boolean z16 = (i & 512) != 0 ? flexInputState.showExpressionTrayButtonBadge : z8;
        boolean z17 = (i & 1024) != 0 ? flexInputState.expressionSuggestionsEnabled : z9;
        Long l3 = (i & 2048) != 0 ? flexInputState.channelId : l;
        Long l4 = (i & 4096) != 0 ? flexInputState.guildId : l2;
        Objects.requireNonNull(flexInputState);
        Intrinsics3.checkNotNullParameter(str2, "inputText");
        Intrinsics3.checkNotNullParameter(list2, "attachments");
        return new FlexInputState(str2, z10, list2, z11, z12, num2, z13, z14, z15, z16, z17, l3, l4);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FlexInputState)) {
            return false;
        }
        FlexInputState flexInputState = (FlexInputState) other;
        return Intrinsics3.areEqual(this.inputText, flexInputState.inputText) && this.showExpandedButtons == flexInputState.showExpandedButtons && Intrinsics3.areEqual(this.attachments, flexInputState.attachments) && this.attachmentViewEnabled == flexInputState.attachmentViewEnabled && this.singleSelectMode == flexInputState.singleSelectMode && Intrinsics3.areEqual(this.showContentDialogIndex, flexInputState.showContentDialogIndex) && this.ableToSendMessages == flexInputState.ableToSendMessages && this.ableToAttachFiles == flexInputState.ableToAttachFiles && this.showExpressionTray == flexInputState.showExpressionTray && this.showExpressionTrayButtonBadge == flexInputState.showExpressionTrayButtonBadge && this.expressionSuggestionsEnabled == flexInputState.expressionSuggestionsEnabled && Intrinsics3.areEqual(this.channelId, flexInputState.channelId) && Intrinsics3.areEqual(this.guildId, flexInputState.guildId);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.inputText;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z2 = this.showExpandedButtons;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode + i) * 31;
        List<Attachment<Object>> list = this.attachments;
        int iHashCode2 = (i2 + (list != null ? list.hashCode() : 0)) * 31;
        boolean z3 = this.attachmentViewEnabled;
        int i3 = z3;
        if (z3 != 0) {
            i3 = 1;
        }
        int i4 = (iHashCode2 + i3) * 31;
        boolean z4 = this.singleSelectMode;
        int i5 = z4;
        if (z4 != 0) {
            i5 = 1;
        }
        int i6 = (i4 + i5) * 31;
        Integer num = this.showContentDialogIndex;
        int iHashCode3 = (i6 + (num != null ? num.hashCode() : 0)) * 31;
        boolean z5 = this.ableToSendMessages;
        int i7 = z5;
        if (z5 != 0) {
            i7 = 1;
        }
        int i8 = (iHashCode3 + i7) * 31;
        boolean z6 = this.ableToAttachFiles;
        int i9 = z6;
        if (z6 != 0) {
            i9 = 1;
        }
        int i10 = (i8 + i9) * 31;
        boolean z7 = this.showExpressionTray;
        int i11 = z7;
        if (z7 != 0) {
            i11 = 1;
        }
        int i12 = (i10 + i11) * 31;
        boolean z8 = this.showExpressionTrayButtonBadge;
        int i13 = z8;
        if (z8 != 0) {
            i13 = 1;
        }
        int i14 = (i12 + i13) * 31;
        boolean z9 = this.expressionSuggestionsEnabled;
        int i15 = (i14 + (z9 ? 1 : z9 ? 1 : 0)) * 31;
        Long l = this.channelId;
        int iHashCode4 = (i15 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.guildId;
        return iHashCode4 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("FlexInputState(inputText=");
        sbM833U.append(this.inputText);
        sbM833U.append(", showExpandedButtons=");
        sbM833U.append(this.showExpandedButtons);
        sbM833U.append(", attachments=");
        sbM833U.append(this.attachments);
        sbM833U.append(", attachmentViewEnabled=");
        sbM833U.append(this.attachmentViewEnabled);
        sbM833U.append(", singleSelectMode=");
        sbM833U.append(this.singleSelectMode);
        sbM833U.append(", showContentDialogIndex=");
        sbM833U.append(this.showContentDialogIndex);
        sbM833U.append(", ableToSendMessages=");
        sbM833U.append(this.ableToSendMessages);
        sbM833U.append(", ableToAttachFiles=");
        sbM833U.append(this.ableToAttachFiles);
        sbM833U.append(", showExpressionTray=");
        sbM833U.append(this.showExpressionTray);
        sbM833U.append(", showExpressionTrayButtonBadge=");
        sbM833U.append(this.showExpressionTrayButtonBadge);
        sbM833U.append(", expressionSuggestionsEnabled=");
        sbM833U.append(this.expressionSuggestionsEnabled);
        sbM833U.append(", channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", guildId=");
        return outline.m819G(sbM833U, this.guildId, ")");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FlexInputState(String str, boolean z2, List list, boolean z3, boolean z4, Integer num, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, Long l, Long l2, int i) {
        this((i & 1) != 0 ? "" : null, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? Collections2.emptyList() : null, (i & 8) != 0 ? true : z3, (i & 16) != 0 ? true : z4, null, (i & 64) != 0 ? true : z5, (i & 128) != 0 ? true : z6, (i & 256) != 0 ? false : z7, (i & 512) == 0 ? z8 : false, (i & 1024) == 0 ? z9 : true, null, null);
        int i2 = i & 32;
        int i3 = i & 2048;
        int i4 = i & 4096;
    }
}
