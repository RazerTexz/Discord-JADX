package com.discord.utilities.search.query.parsing;

import android.content.Context;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.query.node.answer.HasNode;
import com.discord.utilities.search.strings.SearchStringProvider;
import d0.z.d.Intrinsics3;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: QueryParser.kt */
/* renamed from: com.discord.utilities.search.query.parsing.QueryParser$Companion$getHasAnswerRule$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class QueryParser4 extends Rule<Context, QueryNode, Object> {
    public final /* synthetic */ Pattern $hasAnswerPattern;
    public final /* synthetic */ SearchStringProvider $searchStringProvider;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueryParser4(SearchStringProvider searchStringProvider, Pattern pattern, Pattern pattern2) {
        super(pattern2);
        this.$searchStringProvider = searchStringProvider;
        this.$hasAnswerPattern = pattern;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<Context, Object> parse(Matcher matcher, Parser<Context, ? super QueryNode, Object> parser, Object state) {
        Intrinsics3.checkNotNullParameter(matcher, "matcher");
        Intrinsics3.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(1);
        Intrinsics3.checkNotNull(strGroup);
        HasNode hasNode = new HasNode(strGroup, this.$searchStringProvider);
        Intrinsics3.checkNotNullParameter(hasNode, "node");
        return new ParseSpec<>(hasNode, state);
    }
}
