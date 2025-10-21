package com.discord.widgets.chat.input.expression;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ExpressionPickerEvent.kt */
/* loaded from: classes2.dex */
public abstract class ExpressionPickerEvent {

    /* compiled from: ExpressionPickerEvent.kt */
    public static final class CloseExpressionPicker extends ExpressionPickerEvent {
        public static final CloseExpressionPicker INSTANCE = new CloseExpressionPicker();

        private CloseExpressionPicker() {
            super(null);
        }
    }

    /* compiled from: ExpressionPickerEvent.kt */
    public static final /* data */ class OpenStickerPicker extends ExpressionPickerEvent {
        private final boolean inline;
        private final String searchText;
        private final Long stickerPackId;

        public OpenStickerPicker() {
            this(null, null, false, 7, null);
        }

        public /* synthetic */ OpenStickerPicker(Long l, String str, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : str, (i & 4) != 0 ? false : z2);
        }

        public static /* synthetic */ OpenStickerPicker copy$default(OpenStickerPicker openStickerPicker, Long l, String str, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                l = openStickerPicker.stickerPackId;
            }
            if ((i & 2) != 0) {
                str = openStickerPicker.searchText;
            }
            if ((i & 4) != 0) {
                z2 = openStickerPicker.inline;
            }
            return openStickerPicker.copy(l, str, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final Long getStickerPackId() {
            return this.stickerPackId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getSearchText() {
            return this.searchText;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getInline() {
            return this.inline;
        }

        public final OpenStickerPicker copy(Long stickerPackId, String searchText, boolean inline) {
            return new OpenStickerPicker(stickerPackId, searchText, inline);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OpenStickerPicker)) {
                return false;
            }
            OpenStickerPicker openStickerPicker = (OpenStickerPicker) other;
            return Intrinsics3.areEqual(this.stickerPackId, openStickerPicker.stickerPackId) && Intrinsics3.areEqual(this.searchText, openStickerPicker.searchText) && this.inline == openStickerPicker.inline;
        }

        public final boolean getInline() {
            return this.inline;
        }

        public final String getSearchText() {
            return this.searchText;
        }

        public final Long getStickerPackId() {
            return this.stickerPackId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Long l = this.stickerPackId;
            int iHashCode = (l != null ? l.hashCode() : 0) * 31;
            String str = this.searchText;
            int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
            boolean z2 = this.inline;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode2 + i;
        }

        public String toString() {
            StringBuilder sbU = outline.U("OpenStickerPicker(stickerPackId=");
            sbU.append(this.stickerPackId);
            sbU.append(", searchText=");
            sbU.append(this.searchText);
            sbU.append(", inline=");
            return outline.O(sbU, this.inline, ")");
        }

        public OpenStickerPicker(Long l, String str, boolean z2) {
            super(null);
            this.stickerPackId = l;
            this.searchText = str;
            this.inline = z2;
        }
    }

    private ExpressionPickerEvent() {
    }

    public /* synthetic */ ExpressionPickerEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
