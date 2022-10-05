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
    PROBLEM: https://judge.yosupo.jp/problem/number_of_substrings
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 420, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 524, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/number_of_substrings\n\
    \npackage library;\n\nimport library.Solver;\nimport library.Trie;\n\npublic class\
    \ Trie_size_test extends Solver {\n\tpublic static void main(final String[] args)\
    \ { main(args, new Trie_size_test()); }\n\n\tpublic void solve() {\n\t\tString\
    \ t = ns();\n\t\tTrie trie = new Trie();\n\t\tfor(int i = 0; i < t.length(); i\
    \ ++) trie.add(t, i, t.length());\n\t\tprtln(trie.size() - 1);\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/Trie.java
  isVerificationFile: true
  path: library/Trie_size_test.java
  requiredBy: []
  timestamp: '2022-10-05 17:34:40+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: library/Trie_size_test.java
layout: document
redirect_from:
- /verify/library/Trie_size_test.java
- /verify/library/Trie_size_test.java.html
title: library/Trie_size_test.java
---
