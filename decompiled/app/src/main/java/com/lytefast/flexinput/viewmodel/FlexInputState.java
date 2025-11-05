package com.lytefast.flexinput.viewmodel;

import b.d.b.a.a;
import com.lytefast.flexinput.model.Attachment;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import java.util.Objects;

/* compiled from: FlexInputState.kt */
/* loaded from: classes3.dex */
public final /* data */ class FlexInputState {

    /* renamed from: a, reason: from kotlin metadata */
    public final String inputText;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
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
        m.checkNotNullParameter(str, "inputText");
        m.checkNotNullParameter(list, "attachments");
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

    public static FlexInputState a(FlexInputState flexInputState, String str, boolean z2, List list, boolean z3, boolean z4, Integer num, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, Long l, Long l2, int i) {
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
        m.checkNotNullParameter(str2, "inputText");
        m.checkNotNullParameter(list2, "attachments");
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
        return m.areEqual(this.inputText, flexInputState.inputText) && this.showExpandedButtons == flexInputState.showExpandedButtons && m.areEqual(this.attachments, flexInputState.attachments) && this.attachmentViewEnabled == flexInputState.attachmentViewEnabled && this.singleSelectMode == flexInputState.singleSelectMode && m.areEqual(this.showContentDialogIndex, flexInputState.showContentDialogIndex) && this.ableToSendMessages == flexInputState.ableToSendMessages && this.ableToAttachFiles == flexInputState.ableToAttachFiles && this.showExpressionTray == flexInputState.showExpressionTray && this.showExpressionTrayButtonBadge == flexInputState.showExpressionTrayButtonBadge && this.expressionSuggestionsEnabled == flexInputState.expressionSuggestionsEnabled && m.areEqual(this.channelId, flexInputState.channelId) && m.areEqual(this.guildId, flexInputState.guildId);
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
        StringBuilder sbU = a.U("FlexInputState(inputText=");
        sbU.append(this.inputText);
        sbU.append(", showExpandedButtons=");
        sbU.append(this.showExpandedButtons);
        sbU.append(", attachments=");
        sbU.append(this.attachments);
        sbU.append(", attachmentViewEnabled=");
        sbU.append(this.attachmentViewEnabled);
        sbU.append(", singleSelectMode=");
        sbU.append(this.singleSelectMode);
        sbU.append(", showContentDialogIndex=");
        sbU.append(this.showContentDialogIndex);
        sbU.append(", ableToSendMessages=");
        sbU.append(this.ableToSendMessages);
        sbU.append(", ableToAttachFiles=");
        sbU.append(this.ableToAttachFiles);
        sbU.append(", showExpressionTray=");
        sbU.append(this.showExpressionTray);
        sbU.append(", showExpressionTrayButtonBadge=");
        sbU.append(this.showExpressionTrayButtonBadge);
        sbU.append(", expressionSuggestionsEnabled=");
        sbU.append(this.expressionSuggestionsEnabled);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", guildId=");
        return a.G(sbU, this.guildId, ")");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FlexInputState(String str, boolean z2, List list, boolean z3, boolean z4, Integer num, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, Long l, Long l2, int i) {
        this((i & 1) != 0 ? "" : null, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? n.emptyList() : null, (i & 8) != 0 ? true : z3, (i & 16) != 0 ? true : z4, null, (i & 64) != 0 ? true : z5, (i & 128) != 0 ? true : z6, (i & 256) != 0 ? false : z7, (i & 512) == 0 ? z8 : false, (i & 1024) == 0 ? z9 : true, null, null);
        int i2 = i & 32;
        int i3 = i & 2048;
        int i4 = i & 4096;
    }
}
