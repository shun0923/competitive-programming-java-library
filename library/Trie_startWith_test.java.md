---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  - icon: ':heavy_check_mark:'
    path: library/Trie.java
    title: library/Trie.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://yukicoder.me/problems/no/430
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n          \
    \         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\
    \  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/subprocess.py\"\
    , line 466, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\
    \  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/subprocess.py\"\
    , line 571, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "// verification-helper: PROBLEM https://yukicoder.me/problems/no/430\n\n\
    package library;\n\nimport library.Solver;\nimport library.Trie;\n\npublic class\
    \ Trie_startWith_test extends Solver {\n\tpublic static void main(final String[]\
    \ args) { main(args, new Trie_startWith_test()); }\n\n\tpublic void solve() {\n\
    \t\tString t = ns();\n\t\tTrie trie = new Trie();\n\t\tfor(int i = 0; i < t.length();\
    \ i ++) trie.add(t, i, min(i + 10, t.length()));\n\t\tint m = ni();\n\t\tlong\
    \ ans = 0;\n\t\tfor(int i = 0; i < m; i ++) ans += trie.startWith(ns());\n\t\t\
    prtln(ans);\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/Trie.java
  isVerificationFile: true
  path: library/Trie_startWith_test.java
  requiredBy: []
  timestamp: '2023-03-23 19:06:36+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/Trie_startWith_test.java
layout: document
redirect_from:
- /verify/library/Trie_startWith_test.java
- /verify/library/Trie_startWith_test.java.html
title: library/Trie_startWith_test.java
---
