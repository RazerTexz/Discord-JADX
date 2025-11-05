package com.discord.utilities.rest;

import android.content.Context;
import b.a.k.b;
import com.discord.R;
import com.discord.restapi.RestAPIAbortCodes;
import com.discord.utilities.error.Error;
import d0.t.h0;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: RestAPIAbortMessages.kt */
/* loaded from: classes2.dex */
public final class RestAPIAbortMessages {
    public static final RestAPIAbortMessages INSTANCE = new RestAPIAbortMessages();
    private static final Map<Integer, Integer> MESSAGES;

    /* compiled from: RestAPIAbortMessages.kt */
    public static final class ResponseResolver {
        public static final ResponseResolver INSTANCE = new ResponseResolver();

        private ResponseResolver() {
        }

        public final CharSequence getRelationshipResponse(Context context, int abortCode, String username) {
            m.checkNotNullParameter(username, "username");
            Integer abortCodeMessageResId = RestAPIAbortMessages.getAbortCodeMessageResId(abortCode);
            int iIntValue = abortCodeMessageResId != null ? abortCodeMessageResId.intValue() : R.string.add_friend_error_other;
            if (abortCode != 80000) {
                if (context != null) {
                    return b.h(context, iIntValue, new Object[0], null, 4);
                }
                return null;
            }
            if (context != null) {
                return b.h(context, iIntValue, new Object[]{username}, null, 4);
            }
            return null;
        }
    }

    /* compiled from: RestAPIAbortMessages.kt */
    /* renamed from: com.discord.utilities.rest.RestAPIAbortMessages$handleAbortCodeOrDefault$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return true;
        }
    }

    static {
        Integer numValueOf = Integer.valueOf(RestAPIAbortCodes.RELATIONSHIP_INCOMING_DISABLED);
        Integer numValueOf2 = Integer.valueOf(RestAPIAbortCodes.RELATIONSHIP_INCOMING_BLOCKED);
        Integer numValueOf3 = Integer.valueOf(R.string.add_friend_error_other);
        MESSAGES = h0.mapOf(d0.o.to(numValueOf, Integer.valueOf(R.string.bot_requires_email_verification)), d0.o.to(Integer.valueOf(RestAPIAbortCodes.INVALID_MESSAGE_SEND_USER), Integer.valueOf(R.string.bot_dm_send_failed)), d0.o.to(Integer.valueOf(RestAPIAbortCodes.RATE_LIMIT_DM_OPEN), Integer.valueOf(R.string.bot_dm_rate_limited)), d0.o.to(Integer.valueOf(RestAPIAbortCodes.SEND_MESSAGE_TEMPORARILY_DISABLED), Integer.valueOf(R.string.bot_dm_send_message_temporarily_disabled)), d0.o.to(numValueOf, Integer.valueOf(R.string.add_friend_error_invalid_discord_tag)), d0.o.to(Integer.valueOf(RestAPIAbortCodes.TOO_MANY_FRIENDS), Integer.valueOf(R.string.add_friend_error_too_many_friends)), d0.o.to(numValueOf2, numValueOf3), d0.o.to(Integer.valueOf(RestAPIAbortCodes.RELATIONSHIP_INVALID_SELF), numValueOf3), d0.o.to(Integer.valueOf(RestAPIAbortCodes.RELATIONSHIP_INVALID_USER_BOT), numValueOf3), d0.o.to(Integer.valueOf(RestAPIAbortCodes.RELATIONSHIP_INVALID_DISCORD_TAG), numValueOf3), d0.o.to(Integer.valueOf(RestAPIAbortCodes.RELATIONSHIP_ALREADY_FRIENDS), Integer.valueOf(R.string.add_friend_error_already_friends)), d0.o.to(Integer.valueOf(RestAPIAbortCodes.TOO_MANY_THREADS), Integer.valueOf(R.string.too_many_threads_message)), d0.o.to(Integer.valueOf(RestAPIAbortCodes.TOO_MANY_ANNOUNCEMENT_THREADS), Integer.valueOf(R.string.too_many_announcement_threads_message)), d0.o.to(Integer.valueOf(RestAPIAbortCodes.SLOWMODE_RATE_LIMITED), Integer.valueOf(R.string.channel_slowmode_desc_short)));
    }

    private RestAPIAbortMessages() {
    }

    public static final Integer getAbortCodeMessageResId(int abortCode) {
        return MESSAGES.get(Integer.valueOf(abortCode));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void handleAbortCodeOrDefault$default(RestAPIAbortMessages restAPIAbortMessages, Error error, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 4) != 0) {
            function02 = AnonymousClass1.INSTANCE;
        }
        restAPIAbortMessages.handleAbortCodeOrDefault(error, function0, function02);
    }

    public final void handleAbortCodeOrDefault(Error errorResponse, Function0<Unit> onHandle, Function0<Boolean> onDefault) {
        m.checkNotNullParameter(errorResponse, "errorResponse");
        m.checkNotNullParameter(onHandle, "onHandle");
        m.checkNotNullParameter(onDefault, "onDefault");
        if (errorResponse.getType() != Error.Type.DISCORD_BAD_REQUEST) {
            errorResponse.setShowErrorToasts(onDefault.invoke().booleanValue());
        } else {
            errorResponse.setShowErrorToasts(false);
            onHandle.invoke();
        }
    }
}
