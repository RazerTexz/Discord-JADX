package com.discord.api.report;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: InAppReportsMenu.kt */
/* loaded from: classes.dex */
public abstract class ReportNodeBottomButton {
    private final String type;

    /* compiled from: InAppReportsMenu.kt */
    public static final class Cancel extends ReportNodeBottomButton {
        public static final Cancel INSTANCE = new Cancel();

        public Cancel() {
            super("cancel", null);
        }
    }

    /* compiled from: InAppReportsMenu.kt */
    public static final class Done extends ReportNodeBottomButton {
        public static final Done INSTANCE = new Done();

        public Done() {
            super("done", null);
        }
    }

    /* compiled from: InAppReportsMenu.kt */
    public static final /* data */ class Next extends ReportNodeBottomButton {
        private final int target;

        public Next(int i) {
            super("next", null);
            this.target = i;
        }

        /* renamed from: b, reason: from getter */
        public final int getTarget() {
            return this.target;
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Next) && this.target == ((Next) other).target;
            }
            return true;
        }

        public int hashCode() {
            return this.target;
        }

        public String toString() {
            return outline.m814B(outline.m833U("Next(target="), this.target, ")");
        }
    }

    /* compiled from: InAppReportsMenu.kt */
    public static final class Submit extends ReportNodeBottomButton {
        public static final Submit INSTANCE = new Submit();

        public Submit() {
            super("submit", null);
        }
    }

    public ReportNodeBottomButton(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this.type = str;
    }

    /* renamed from: a, reason: from getter */
    public final String getType() {
        return this.type;
    }
}
