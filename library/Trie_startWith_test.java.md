---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  - icon: ':x:'
    path: library/Trie.java
    title: library/Trie.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes:
    PROBLEM: https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_14_D
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 420, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 524, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_14_D\n\
    \npackage library;\n\nimport library.Solver;\nimport library.Trie;\n\npublic class\
    \ Trie_startWith_test extends Solver {\n\tpublic static void main(final String[]\
    \ args) { main(args, new Trie_startWith_test()); }\n\n\tpublic void solve() {\n\
    \t\tString t = ns();\n\t\tTrie trie = new Trie(62);\n\t\tfor(int i = 0; i < t.length();\
    \ i ++) trie.add(t, i, t.length());\n\t\tint q = ni();\n\t\tfor(int i = 0; i <\
    \ q; i ++) prtln(trie.startWith(ns()) ? 1 : 0);\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/Trie.java
  isVerificationFile: true
  path: library/Trie_startWith_test.java
  requiredBy: []
  timestamp: '2022-10-05 21:02:04+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: library/Trie_startWith_test.java
layout: document
redirect_from:
- /verify/library/Trie_startWith_test.java
- /verify/library/Trie_startWith_test.java.html
title: library/Trie_startWith_test.java
---
