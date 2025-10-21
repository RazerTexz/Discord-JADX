package com.discord.widgets.chat.input.models;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.ranges.Ranges2;

/* compiled from: OptionRange.kt */
/* loaded from: classes2.dex */
public final /* data */ class OptionRange {
    private final Ranges2 param;
    private final Ranges2 value;

    public OptionRange(Ranges2 ranges2, Ranges2 ranges22) {
        Intrinsics3.checkNotNullParameter(ranges2, "param");
        Intrinsics3.checkNotNullParameter(ranges22, "value");
        this.param = ranges2;
        this.value = ranges22;
    }

    public static /* synthetic */ OptionRange copy$default(OptionRange optionRange, Ranges2 ranges2, Ranges2 ranges22, int i, Object obj) {
        if ((i & 1) != 0) {
            ranges2 = optionRange.param;
        }
        if ((i & 2) != 0) {
            ranges22 = optionRange.value;
        }
        return optionRange.copy(ranges2, ranges22);
    }

    /* renamed from: component1, reason: from getter */
    public final Ranges2 getParam() {
        return this.param;
    }

    /* renamed from: component2, reason: from getter */
    public final Ranges2 getValue() {
        return this.value;
    }

    public final OptionRange copy(Ranges2 param, Ranges2 value) {
        Intrinsics3.checkNotNullParameter(param, "param");
        Intrinsics3.checkNotNullParameter(value, "value");
        return new OptionRange(param, value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OptionRange)) {
            return false;
        }
        OptionRange optionRange = (OptionRange) other;
        return Intrinsics3.areEqual(this.param, optionRange.param) && Intrinsics3.areEqual(this.value, optionRange.value);
    }

    public final Ranges2 getParam() {
        return this.param;
    }

    public final Ranges2 getValue() {
        return this.value;
    }

    public int hashCode() {
        Ranges2 ranges2 = this.param;
        int iHashCode = (ranges2 != null ? ranges2.hashCode() : 0) * 31;
        Ranges2 ranges22 = this.value;
        return iHashCode + (ranges22 != null ? ranges22.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("OptionRange(param=");
        sbU.append(this.param);
        sbU.append(", value=");
        sbU.append(this.value);
        sbU.append(")");
        return sbU.toString();
    }
}
