package com.discord.models.domain;

import com.discord.models.domain.Model;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: ModelPhoneVerificationToken.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelPhoneVerificationToken {
    private final String token;

    /* JADX INFO: compiled from: ModelPhoneVerificationToken.kt */
    public static final /* data */ class Update {
        private final String token;

        /* JADX INFO: compiled from: ModelPhoneVerificationToken.kt */
        public static final class Parser implements Model.Parser<Update> {
            public static final Parser INSTANCE = new Parser();

            private Parser() {
            }

            @Override // com.discord.models.domain.Model.Parser
            public /* bridge */ /* synthetic */ Update parse(Model.JsonReader jsonReader) {
                return parse(jsonReader);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.discord.models.domain.Model.Parser
            public Update parse(Model.JsonReader reader) throws IOException {
                Ref$ObjectRef ref$ObjectRefM844c0 = outline.m844c0(reader, "reader");
                ref$ObjectRefM844c0.element = "";
                reader.nextObject(new ModelPhoneVerificationToken2(ref$ObjectRefM844c0, reader));
                return new Update((String) ref$ObjectRefM844c0.element);
            }
        }

        public Update(String str) {
            Intrinsics3.checkNotNullParameter(str, "token");
            this.token = str;
        }

        public static /* synthetic */ Update copy$default(Update update, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = update.token;
            }
            return update.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getToken() {
            return this.token;
        }

        public final Update copy(String token) {
            Intrinsics3.checkNotNullParameter(token, "token");
            return new Update(token);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Update) && Intrinsics3.areEqual(this.token, ((Update) other).token);
            }
            return true;
        }

        public final String getToken() {
            return this.token;
        }

        public int hashCode() {
            String str = this.token;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return outline.m822J(outline.m833U("Update(token="), this.token, ")");
        }
    }

    public ModelPhoneVerificationToken(String str) {
        Intrinsics3.checkNotNullParameter(str, "token");
        this.token = str;
    }

    public static /* synthetic */ ModelPhoneVerificationToken copy$default(ModelPhoneVerificationToken modelPhoneVerificationToken, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelPhoneVerificationToken.token;
        }
        return modelPhoneVerificationToken.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    public final ModelPhoneVerificationToken copy(String token) {
        Intrinsics3.checkNotNullParameter(token, "token");
        return new ModelPhoneVerificationToken(token);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ModelPhoneVerificationToken) && Intrinsics3.areEqual(this.token, ((ModelPhoneVerificationToken) other).token);
        }
        return true;
    }

    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        String str = this.token;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.m822J(outline.m833U("ModelPhoneVerificationToken(token="), this.token, ")");
    }
}
