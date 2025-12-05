package com.discord.utilities.rest;

import android.content.Context;
import com.discord.C5419R;
import com.discord.restapi.RestAPIAbortCodes;
import com.discord.utilities.error.Error;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p007b.p008a.p027k.FormatUtils;
import p507d0.Tuples;
import p507d0.p580t.Maps6;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

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
            Intrinsics3.checkNotNullParameter(username, "username");
            Integer abortCodeMessageResId = RestAPIAbortMessages.getAbortCodeMessageResId(abortCode);
            int iIntValue = abortCodeMessageResId != null ? abortCodeMessageResId.intValue() : C5419R.string.add_friend_error_other;
            if (abortCode != 80000) {
                if (context != null) {
                    return FormatUtils.m216h(context, iIntValue, new Object[0], null, 4);
                }
                return null;
            }
            if (context != null) {
                return FormatUtils.m216h(context, iIntValue, new Object[]{username}, null, 4);
            }
            return null;
        }
    }

    /* compiled from: RestAPIAbortMessages.kt */
    /* renamed from: com.discord.utilities.rest.RestAPIAbortMessages$handleAbortCodeOrDefault$1 */
    public static final class C68601 extends Lambda implements Function0<Boolean> {
        public static final C68601 INSTANCE = new C68601();

        public C68601() {
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
        Integer numValueOf3 = Integer.valueOf(C5419R.string.add_friend_error_other);
        MESSAGES = Maps6.mapOf(Tuples.m10073to(numValueOf, Integer.valueOf(C5419R.string.bot_requires_email_verification)), Tuples.m10073to(Integer.valueOf(RestAPIAbortCodes.INVALID_MESSAGE_SEND_USER), Integer.valueOf(C5419R.string.bot_dm_send_failed)), Tuples.m10073to(Integer.valueOf(RestAPIAbortCodes.RATE_LIMIT_DM_OPEN), Integer.valueOf(C5419R.string.bot_dm_rate_limited)), Tuples.m10073to(Integer.valueOf(RestAPIAbortCodes.SEND_MESSAGE_TEMPORARILY_DISABLED), Integer.valueOf(C5419R.string.bot_dm_send_message_temporarily_disabled)), Tuples.m10073to(numValueOf, Integer.valueOf(C5419R.string.add_friend_error_invalid_discord_tag)), Tuples.m10073to(Integer.valueOf(RestAPIAbortCodes.TOO_MANY_FRIENDS), Integer.valueOf(C5419R.string.add_friend_error_too_many_friends)), Tuples.m10073to(numValueOf2, numValueOf3), Tuples.m10073to(Integer.valueOf(RestAPIAbortCodes.RELATIONSHIP_INVALID_SELF), numValueOf3), Tuples.m10073to(Integer.valueOf(RestAPIAbortCodes.RELATIONSHIP_INVALID_USER_BOT), numValueOf3), Tuples.m10073to(Integer.valueOf(RestAPIAbortCodes.RELATIONSHIP_INVALID_DISCORD_TAG), numValueOf3), Tuples.m10073to(Integer.valueOf(RestAPIAbortCodes.RELATIONSHIP_ALREADY_FRIENDS), Integer.valueOf(C5419R.string.add_friend_error_already_friends)), Tuples.m10073to(Integer.valueOf(RestAPIAbortCodes.TOO_MANY_THREADS), Integer.valueOf(C5419R.string.too_many_threads_message)), Tuples.m10073to(Integer.valueOf(RestAPIAbortCodes.TOO_MANY_ANNOUNCEMENT_THREADS), Integer.valueOf(C5419R.string.too_many_announcement_threads_message)), Tuples.m10073to(Integer.valueOf(RestAPIAbortCodes.SLOWMODE_RATE_LIMITED), Integer.valueOf(C5419R.string.channel_slowmode_desc_short)));
    }

    private RestAPIAbortMessages() {
    }

    public static final Integer getAbortCodeMessageResId(int abortCode) {
        return MESSAGES.get(Integer.valueOf(abortCode));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void handleAbortCodeOrDefault$default(RestAPIAbortMessages restAPIAbortMessages, Error error, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 4) != 0) {
            function02 = C68601.INSTANCE;
        }
        restAPIAbortMessages.handleAbortCodeOrDefault(error, function0, function02);
    }

    public final void handleAbortCodeOrDefault(Error errorResponse, Function0<Unit> onHandle, Function0<Boolean> onDefault) {
        Intrinsics3.checkNotNullParameter(errorResponse, "errorResponse");
        Intrinsics3.checkNotNullParameter(onHandle, "onHandle");
        Intrinsics3.checkNotNullParameter(onDefault, "onDefault");
        if (errorResponse.getType() != Error.Type.DISCORD_BAD_REQUEST) {
            errorResponse.setShowErrorToasts(onDefault.invoke().booleanValue());
        } else {
            errorResponse.setShowErrorToasts(false);
            onHandle.invoke();
        }
    }
}
