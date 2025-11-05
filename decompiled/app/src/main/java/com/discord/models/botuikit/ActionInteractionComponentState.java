package com.discord.models.botuikit;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.webrtc.PeerConnectionFactory;

/* compiled from: ActionInteractionComponentState.kt */
/* loaded from: classes.dex */
public abstract class ActionInteractionComponentState {

    /* compiled from: ActionInteractionComponentState.kt */
    public static final class Disabled extends ActionInteractionComponentState {
        public static final Disabled INSTANCE = new Disabled();

        private Disabled() {
            super(null);
        }
    }

    /* compiled from: ActionInteractionComponentState.kt */
    public static final class Enabled extends ActionInteractionComponentState {
        public static final Enabled INSTANCE = new Enabled();

        private Enabled() {
            super(null);
        }
    }

    /* compiled from: ActionInteractionComponentState.kt */
    public static final /* data */ class Failed extends ActionInteractionComponentState {
        private final String errorMessage;

        public Failed(String str) {
            super(null);
            this.errorMessage = str;
        }

        public static /* synthetic */ Failed copy$default(Failed failed, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = failed.errorMessage;
            }
            return failed.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public final Failed copy(String errorMessage) {
            return new Failed(errorMessage);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Failed) && m.areEqual(this.errorMessage, ((Failed) other).errorMessage);
            }
            return true;
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public int hashCode() {
            String str = this.errorMessage;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return a.J(a.U("Failed(errorMessage="), this.errorMessage, ")");
        }
    }

    /* compiled from: ActionInteractionComponentState.kt */
    public static final class Loading extends ActionInteractionComponentState {
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super(null);
        }
    }

    private ActionInteractionComponentState() {
    }

    public /* synthetic */ ActionInteractionComponentState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
