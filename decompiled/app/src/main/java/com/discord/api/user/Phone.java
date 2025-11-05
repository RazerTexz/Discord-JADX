package com.discord.api.user;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Phone.kt */
/* loaded from: classes.dex */
public abstract class Phone {

    /* compiled from: Phone.kt */
    public static final class NoPhoneNumber extends Phone {
        public static final NoPhoneNumber INSTANCE = new NoPhoneNumber();

        public NoPhoneNumber() {
            super(null);
        }
    }

    /* compiled from: Phone.kt */
    public static final /* data */ class PhoneNumber extends Phone {
        private final String number;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PhoneNumber(String str) {
            super(null);
            m.checkNotNullParameter(str, "number");
            this.number = str;
        }

        /* renamed from: a, reason: from getter */
        public final String getNumber() {
            return this.number;
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof PhoneNumber) && m.areEqual(this.number, ((PhoneNumber) other).number);
            }
            return true;
        }

        public int hashCode() {
            String str = this.number;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return a.J(a.U("PhoneNumber(number="), this.number, ")");
        }
    }

    public Phone() {
    }

    public Phone(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
